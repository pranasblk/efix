package org.f1x.util.concurrent;

import org.f1x.util.buffer.AtomicBuffer;
import org.f1x.util.buffer.Buffer;


public class MPSCRingBuffer extends AbstractRingBuffer implements RingBuffer {

    public MPSCRingBuffer(AtomicBuffer buffer) {
        super(buffer);
    }

    @Override
    public boolean write(int messageType, Buffer srcBuffer, int srcOffset, int length) {
        checkMessageType(messageType);
        checkMessageLength(length);

        AtomicBuffer buffer = this.buffer;
        int recordLength = recordLength(length);
        int alignedRecordLength = align(recordLength);
        int recordOffset = claim(alignedRecordLength, buffer);

        if (recordOffset == INSUFFICIENT_SPACE)
            return false;

        buffer.putInt(messageTypeOffset(recordOffset), messageType);
        buffer.putBytes(messageOffset(recordOffset), srcBuffer, srcOffset, length);
        buffer.putIntOrdered(recordLengthOffset(recordOffset), recordLength);

        return true;
    }

    @Override
    public int read(MessageHandler handler) {
        int messagesRead = 0;

        AtomicBuffer buffer = this.buffer;
        int capacity = this.capacity;
        long tail = tailSequence.get();

        int bytesRead = 0;

        while (bytesRead < capacity) {
            int recordOffset = mask(tail + bytesRead);
            int recordLength = buffer.getIntVolatile(recordLengthOffset(recordOffset));
            if (recordLength == 0)
                break;

            int alignedLength = align(recordLength);
            bytesRead += alignedLength;
            int messageType = buffer.getInt(messageTypeOffset(recordOffset));
            int zeroingLength = 0;

            try {
                if (messageType == MESSAGE_TYPE_PADDING) {
                    zeroingLength = HEADER_LENGTH;
                } else {
                    zeroingLength = alignedLength;
                    handler.onMessage(messageType, buffer, messageOffset(recordOffset), messageLength(recordLength));
                    messagesRead++;
                }
            } finally {
                buffer.setMemory(recordOffset, zeroingLength, (byte) 0);
                tailSequence.setOrdered(tail + bytesRead);
            }
        }

        return messagesRead;
    }

    private int claim(int required, AtomicBuffer buffer) {
        int capacity = this.capacity;
        long tail = tailCacheSequence.getVolatile();

        long head;
        int headIndex;
        int padding;

        do {
            head = headSequence.getVolatile();

            if (required > freeSpace(head, tail, capacity)) {
                tail = tailSequence.getVolatile();
                if (required > freeSpace(head, tail, capacity))
                    return INSUFFICIENT_SPACE;

                tailCacheSequence.setOrdered(tail);
            }

            padding = 0;
            headIndex = mask(head);
            int continuous = capacity - headIndex;

            if (required > continuous) {
                int tailIndex = mask(tail);
                if (required > tailIndex)
                    return INSUFFICIENT_SPACE;

                padding = continuous;
            }
        }
        while (!headSequence.compareAndSwap(head, head + required + padding));

        if (padding != 0) {
            buffer.putInt(messageTypeOffset(headIndex), MESSAGE_TYPE_PADDING);
            buffer.putIntOrdered(recordLengthOffset(headIndex), padding);
            headIndex = 0;
        }

        return headIndex;
    }

}
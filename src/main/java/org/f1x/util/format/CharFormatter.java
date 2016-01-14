package org.f1x.util.format;

import org.f1x.util.MutableInt;
import org.f1x.util.buffer.MutableBuffer;

public class CharFormatter {

    public static void formatChar(char value, MutableBuffer buffer, MutableInt offset, int end) {
        ByteFormatter.formatByte((byte) value, buffer, offset, end);
    }

    public static void formatChars(CharSequence value, int valueOffset, int valueLength, MutableBuffer buffer, MutableInt offset, int end) {
        int off = offset.value();
        FormatterUtil.checkFreeSpace(end - off, valueLength);

        for (int i = 0; i < valueLength; i++)
            buffer.putByte(off + i, (byte) value.charAt(valueOffset + i));

        offset.value(off + valueLength);
    }

}
package org.efix.util.parse;

import org.efix.util.MutableInt;
import org.efix.util.buffer.Buffer;
import org.efix.util.type.DoubleType;

import static org.efix.util.parse.ParserUtil.*;

@SuppressWarnings("Duplicates")
public class DoubleParser {

    private static final double[] INVERSE_POW_10 = {1E0, 1E-1, 1E-2, 1E-3, 1E-4, 1E-5, 1E-6, 1E-7, 1E-8, 1E-9, 1E-10, 1E-11, 1E-12, 1E-13, 1E-14};

    public static double parseDouble(byte separator, Buffer buffer, MutableInt offset, int end) {
        int start = offset.get();
        int off = start;

        checkFreeSpace(end - off, DoubleType.MIN_LENGTH + 1);

        byte b = buffer.getByte(off++);
        if (isDigit(b)) {
            long value = digit(b);

            do {
                b = buffer.getByte(off++);
                if (isDigit(b)) {
                    value = (value << 3) + (value << 1) + digit(b);
                } else if (b == '.') {
                    int fractionalOffset = off;

                    while (off < end) {
                        b = buffer.getByte(off++);
                        if (isDigit(b)) {
                            value = (value << 3) + (value << 1) + digit(b);
                        } else if (b == separator) {
                            checkValueLength(off - start - 1, DoubleType.MAX_UNSIGNED_FRACTIONAL_LENGTH);
                            offset.set(off);
                            return computeDouble(value, off - fractionalOffset - 1);
                        } else {
                            throwInvalidChar(b);
                        }
                    }

                } else if (b == separator) {
                    checkValueLength(off - start - 1, DoubleType.MAX_UNSIGNED_INTEGER_LENGTH);
                    offset.set(off);
                    return value;
                } else {
                    throwInvalidChar(b);
                }
            } while (off < end);

        } else if (b == '-') {
            b = buffer.getByte(off++);
            if (isDigit(b)) {
                long value = digit(b);

                while (off < end) {
                    b = buffer.getByte(off++);
                    if (isDigit(b)) {
                        value = (value << 3) + (value << 1) + digit(b);
                    } else if (b == '.') {
                        int fractionalOffset = off;

                        while (off < end) {
                            b = buffer.getByte(off++);
                            if (isDigit(b)) {
                                value = (value << 3) + (value << 1) + digit(b);
                            } else if (b == separator) {
                                checkValueLength(off - start - 1, DoubleType.MAX_NEGATIVE_FRACTIONAL_LENGTH);
                                offset.set(off);
                                return -computeDouble(value, off - fractionalOffset - 1);
                            } else {
                                throwInvalidChar(b);
                            }
                        }

                    } else if (b == separator) {
                        checkValueLength(off - start - 1, DoubleType.MAX_NEGATIVE_INTEGER_LENGTH);
                        offset.set(off);
                        return -((double) value);
                    } else {
                        throwInvalidChar(b);
                    }
                }

            } else {
                throwInvalidChar(b);
            }
        } else {
            throwInvalidChar(b);
        }

        throw throwSeparatorNotFound(separator);
    }

    protected static double computeDouble(long value, int fractionalLength) {
        return value * INVERSE_POW_10[fractionalLength];
    }

    protected static void checkValueLength(int length, int max) {
        if (length > max)
            throw new ParserException(String.format("number is too long, length %s, max length %s", length, max));
    }

}
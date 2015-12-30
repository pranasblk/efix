package org.f1x.util.parse.newOne;

public class ParserUtil {

    public static final int MIN_LENGTH = 2;

    public static void checkMinLength(int length, int min) {
        if (length < min)
            throw new ParserException(String.format("length %s < min %s", length, min));
    }

    public static int checkDigit(byte b) {
        if (!isDigit(b))
            throwInvalidChar(b);

        return digit(b);
    }

    public static int checkByte(byte b, byte expected) {
        if (b != expected)
            throwInvalidChar(b);

        return b;
    }

    public static int digit(byte b) {
        return b - '0';
    }

    public static boolean isDigit(byte b) {
        return byteInRange(b, '0', '9');
    }

    public static boolean byteInRange(byte b, char from, char to) {
        return b >= from && b <= to;
    }

    public static ParserException throwInvalidChar(byte b) {
        throw new ParserException("invalid character " + (char) b);
    }

    public static ParserException throwSeparatorNotFound(byte separator) {
        throw new ParserException(String.format("separator %s is not found", (char) separator));
    }

}

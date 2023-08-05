package ru.otus.numberswriter.assertions;

public class Assertions {

    public static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError(String.format("Expected %d = %d", expected, actual));
        }
    }

    public static void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(String.format("Expected \"%s\" = \"%s\"", expected, actual));
        }
    }
}

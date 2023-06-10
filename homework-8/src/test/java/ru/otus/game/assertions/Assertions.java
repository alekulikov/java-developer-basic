package ru.otus.game.assertions;

public class Assertions {

    public static void assertTrue(boolean actual) {
        if (!actual) {
            throw new AssertionError("Expected true, but result is false");
        }
    }

    public static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError(String.format("Expected %d = %d", expected, actual));
        }
    }

    public static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(String.format("Expected \"%s\" = \"%s\"", expected, actual));
        }
    }

}

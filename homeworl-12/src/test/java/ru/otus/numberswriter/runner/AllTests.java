package ru.otus.numberswriter.runner;

import ru.otus.numberswriter.MorferImplTest;
import ru.otus.numberswriter.NumbersWriterTest;

public class AllTests {
    public static void main(String[] args) {
        new MorferImplTest().testNumberEndsWithOne();
        new MorferImplTest().testNumberEndsWithTwentyTwo();
        new MorferImplTest().testNumberEndsWithEleven();
        new NumbersWriterTest().testZeroNumber();
        new NumbersWriterTest().testThousandsNumberGender();
        new NumbersWriterTest().testMaximumNumber();
        new NumbersWriterTest().testNumberWithZerosInMiddle();
    }
}

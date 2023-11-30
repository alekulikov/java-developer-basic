package ru.otus.numberswriter;

import ru.otus.numberswriter.assertions.Assertions;
import ru.otus.numberswriter.fakes.MorferSpy;

import java.util.ArrayList;
import java.util.List;

public class NumbersWriterTest {

    public void testZeroNumber() {
        String scenario = "Тест ситуации, когда на вход передается ноль";
        try {
            List<Object> actualMorferArguments = new ArrayList<>();
            MorferSpy morferSpy = new MorferSpy(actualMorferArguments);
            NumbersWriter numbersWriter = new NumbersWriter(morferSpy, Currency.RUB, new InputNumberValidator());
            List<Object> expectedMorferArguments = List.of(
                    0L,
                    Currency.RUB.getForms()
            );
            String expectedResult = "ноль morferTestResult";
            String actualResult = numbersWriter.getNumberInWords(0L);

            Assertions.assertEquals(expectedMorferArguments.size(), actualMorferArguments.size());
            for (int i = 0; i < expectedMorferArguments.size(); i++) {
                Assertions.assertEquals(expectedMorferArguments.get(i), actualMorferArguments.get(i));
            }
            Assertions.assertEquals(expectedResult, actualResult);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testThousandsNumberGender() {
        String scenario = "Тест ситуации, когда на вход передаются тысячи";
        try {
            List<Object> actualMorferArguments = new ArrayList<>();
            MorferSpy morferSpy = new MorferSpy(actualMorferArguments);
            NumbersWriter numbersWriter = new NumbersWriter(morferSpy, Currency.RUB, new InputNumberValidator());
            List<Object> expectedMorferArguments = List.of(
                    121999L,
                    Currency.RUB.getForms(),
                    121L,
                    List.of("тысяча", "тысячи", "тысяч")
            );
            String expectedResult = "сто двадцать одна morferTestResult девятьсот девяносто девять morferTestResult";
            String actualResult = numbersWriter.getNumberInWords(121999L);

            Assertions.assertEquals(expectedMorferArguments.size(), actualMorferArguments.size());
            for (int i = 0; i < expectedMorferArguments.size(); i++) {
                Assertions.assertEquals(expectedMorferArguments.get(i), actualMorferArguments.get(i));
            }
            Assertions.assertEquals(expectedResult, actualResult);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testMaximumNumber() {
        String scenario = "Тест ситуации, когда на вход передается максимальное число";
        try {
            List<Object> actualMorferArguments = new ArrayList<>();
            MorferSpy morferSpy = new MorferSpy(actualMorferArguments);
            NumbersWriter numbersWriter = new NumbersWriter(morferSpy, Currency.RUB, new InputNumberValidator());
            List<Object> expectedMorferArguments = List.of(
                    999999999999L,
                    Currency.RUB.getForms(),
                    999L,
                    List.of("тысяча", "тысячи", "тысяч"),
                    999L,
                    List.of("миллион", "миллиона", "миллионов"),
                    999L,
                    List.of("миллиард", "миллиарда", "миллиардов")
            );
            String expectedResult = """
                    девятьсот девяносто девять morferTestResult \
                    девятьсот девяносто девять morferTestResult \
                    девятьсот девяносто девять morferTestResult \
                    девятьсот девяносто девять morferTestResult""";
            String actualResult = numbersWriter.getNumberInWords(999999999999L);

            Assertions.assertEquals(expectedMorferArguments.size(), actualMorferArguments.size());
            for (int i = 0; i < expectedMorferArguments.size(); i++) {
                Assertions.assertEquals(expectedMorferArguments.get(i), actualMorferArguments.get(i));
            }
            Assertions.assertEquals(expectedResult, actualResult);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testNumberWithZerosInMiddle() {
        String scenario = "Тест ситуации, когда на вход передается число с нулевыми разрядами";
        try {
            List<Object> actualMorferArguments = new ArrayList<>();
            MorferSpy morferSpy = new MorferSpy(actualMorferArguments);
            NumbersWriter numbersWriter = new NumbersWriter(morferSpy, Currency.RUB, new InputNumberValidator());
            List<Object> expectedMorferArguments = List.of(
                    111000000222L,
                    Currency.RUB.getForms(),
                    111L,
                    List.of("миллиард", "миллиарда", "миллиардов")
            );
            String expectedResult = "сто одиннадцать morferTestResult двести двадцать два morferTestResult";
            String actualResult = numbersWriter.getNumberInWords(111000000222L);

            Assertions.assertEquals(expectedMorferArguments.size(), actualMorferArguments.size());
            for (int i = 0; i < expectedMorferArguments.size(); i++) {
                Assertions.assertEquals(expectedMorferArguments.get(i), actualMorferArguments.get(i));
            }
            Assertions.assertEquals(expectedResult, actualResult);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}

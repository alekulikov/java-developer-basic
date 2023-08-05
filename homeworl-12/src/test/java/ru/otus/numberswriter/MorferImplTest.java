package ru.otus.numberswriter;

import ru.otus.numberswriter.assertions.Assertions;

import java.util.List;

public class MorferImplTest {

    public void testNumberEndsWithOne() {
        String scenario = "Тест ситуации, когда на число заканчивается на 1";
        try {
            Morfer morfer = new MorferImpl();
            String expectedResult = "form1";
            String actualResult = morfer.morf(101L, List.of("form1", "form2", "form3"));

            Assertions.assertEquals(expectedResult, actualResult);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testNumberEndsWithTwentyTwo() {
        String scenario = "Тест ситуации, когда на число заканчивается на 22";
        try {
            Morfer morfer = new MorferImpl();
            String expectedResult = "form2";
            String actualResult = morfer.morf(122L, List.of("form1", "form2", "form3"));

            Assertions.assertEquals(expectedResult, actualResult);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testNumberEndsWithEleven() {
        String scenario = "Тест ситуации, когда на число заканчивается на 11";
        try {
            Morfer morfer = new MorferImpl();
            String expectedResult = "form3";
            String actualResult = morfer.morf(111L, List.of("form1", "form2", "form3"));

            Assertions.assertEquals(expectedResult, actualResult);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}

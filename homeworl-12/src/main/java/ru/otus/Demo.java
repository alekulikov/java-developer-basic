package ru.otus;

import ru.otus.numberswriter.*;

public class Demo {
    public static void main(String[] args) {
        Morfer morfer = new MorferImpl();
        Validator validator = new InputNumberValidator();
        NumbersWriter numbersWriter = new NumbersWriter(morfer, Currency.RUB, validator);
        System.out.println(numbersWriter.getNumberInWords(5000101102L));
    }
}

package ru.otus;

import ru.otus.numberswriter.*;

public class Demo {
    public static void main(String[] args) {
        Morfer morfer = new MorferImpl();
        Currency rub = new CurrencyRub();
        NumbersWriter numbersWriter = new NumbersWriter(morfer, rub);
        System.out.println(numbersWriter.getNumberInWords(5000101102L));
    }
}

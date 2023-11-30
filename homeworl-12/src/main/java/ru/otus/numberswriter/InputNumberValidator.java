package ru.otus.numberswriter;

import java.util.Arrays;

public class InputNumberValidator implements Validator {
    @Override
    public void validate(Object... arguments) {
        if ((Long) arguments[0] > 999999999999L) {
            throw new IllegalArgumentException("Такой размер чисел еще не поддерживается");
        }
        if ((Long) arguments[0] < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным");
        }
    }
}

package ru.otus.numberswriter;

import java.util.List;

public class MorferImpl implements Morfer {
    @Override
    public String morf(Long number, List<String> wordsForms) {
        int modulo;
        if (number % 100 < 10 || number % 100 > 19) {
            modulo = (int) (number % 10);
        } else {
            modulo = (int) (number % 100);
        }
        try {
            return switch (modulo) {
                case 1 -> wordsForms.get(0);
                case 2, 3, 4 -> wordsForms.get(1);
                default -> wordsForms.get(2);
            };
        } catch (IndexOutOfBoundsException e) {
            return "";
        }
    }
}

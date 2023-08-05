package ru.otus.numberswriter;

import java.util.List;

public class CurrencyRub implements Currency {
    private static final List<String> FORMS = List.of(
            "рубль",
            "рубля",
            "рублей"
    );
    @Override
    public List<String> getForms() {
        return FORMS;
    }
}

package ru.otus.numberswriter;

import java.util.List;

public enum Currency {
    RUB(List.of("рубль", "рубля", "рублей")),
    USD(List.of("доллар", "доллара", "долларов"));
    private final List<String> forms;

    Currency(List<String> forms) {
        this.forms = forms;
    }

    List<String> getForms() {
        return forms;
    }
}

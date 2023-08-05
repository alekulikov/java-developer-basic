package ru.otus.numberswriter.fakes;

import ru.otus.numberswriter.Morfer;

import java.util.List;

public class MorferSpy implements Morfer {
    private final List<Object> arguments;

    public MorferSpy(List<Object> actualFlow) {
        this.arguments = actualFlow;
    }

    @Override
    public String morf(Long number, List<String> wordsForms) {
        arguments.add(number);
        arguments.add(wordsForms);
        return "morferTestResult";
    }
}
package ru.otus.testingsystem;

public class AnswerOption {
    private final int number;
    private final Question question;
    private final String text;
    private final boolean isRight;

    public AnswerOption(int number, Question question, String text, boolean isRight) {
        this.number = number;
        this.question = question;
        this.text = text;
        this.isRight = isRight;
    }

    public void print() {
        System.out.println(number + "." + "\t" + text);
    }

    public boolean isRight() {
        return isRight;
    }
}

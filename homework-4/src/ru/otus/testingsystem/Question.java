package ru.otus.testingsystem;

public class Question {
    private static int count = 0;
    private final int number;
    private final String text;
    private final AnswerOption[] answers;

    public Question(String text, AnswerOption[] answers) {
        this.number = ++count;
        this.text = text;
        this.answers = answers;
    }

    public void print() {
        System.out.println("=".repeat(50) + "\n" + number + ")" + "\t" + text);
        for (AnswerOption answer : answers) {
            answer.print();
        }
    }

    public boolean isRightAnswer(int answerNumber) {
        return answers[answerNumber - 1].isRight();
    }
}

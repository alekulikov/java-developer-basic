package ru.otus.testingsystem;

import java.util.Scanner;

public class Main {
    private static final String[] QUESTIONS = {
            "Какое стихийное бедствие измеряется по шкале Рихтера?",
            "Какая планета находится ближе всего к Солнцу?",
            "Кто была первой женщиной, получившей Нобелевскую премию в 1903 году?"
    };
    private static final String[] CORRECT_ANSWERS = {"Землетрясения", "Меркурий", "Мария Кюри"};
    private static final String[][] ANSWER_OPTIONS = {
            {"Торнадо", "Землетрясения", "Наводнения", "Ураган"},
            {"Земля", "Марс", "Меркурий", "Венера", "Сатурн"},
            {"Мария Кюри", "Джейн Аддамс"}
    };

    public static void main(String[] args) {
        int correctCount = 0;
        int wrongCount = 0;
        Question[] questions = loadTestingSystem();
        Scanner console = new Scanner(System.in);
        for (Question question : questions) {
            question.print();
            System.out.print("Введите номер правильного ответа: ");
            int userAnswer = console.nextInt();
            boolean isRight = question.isRightAnswer(userAnswer);
            if (isRight) {
                correctCount++;
            } else {
                wrongCount++;
            }
        }
        System.out.println("Результат: правильно " + correctCount + ", неправильно " + wrongCount);
    }

    public static Question[] loadTestingSystem() {
        Question[] questions = new Question[QUESTIONS.length];
        for (int i = 0; i < QUESTIONS.length; i++) {
            AnswerOption[] answers = new AnswerOption[ANSWER_OPTIONS[i].length];
            Question question = new Question(QUESTIONS[i], answers);
            questions[i] = question;
            for (int j = 0; j < ANSWER_OPTIONS[i].length; j++) {
                boolean isRight = ANSWER_OPTIONS[i][j].equals(CORRECT_ANSWERS[i]);
                int number = j + 1;
                AnswerOption answer = new AnswerOption(number, question, ANSWER_OPTIONS[i][j], isRight);
                answers[j] = answer;
            }
        }
        return questions;
    }
}

import java.util.Scanner;

public class TestingSystem {
    public static void main(String[] args) {
        int correctCount = 0;
        int wrongCount = 0;
        String[] questions = {
                "Какое стихийное бедствие измеряется по шкале Рихтера?",
                "Какая планета находится ближе всего к Солнцу?",
                "Кто была первой женщиной, получившей Нобелевскую премию в 1903 году?"
        };
        String[] correctAnswers = {"Землетрясения", "Меркурий", "Мария Кюри"};
        String[][] answerOptions = {
                {"Торнадо", "Землетрясения", "Наводнения", "Ураган"},
                {"Земля", "Марс", "Меркурий", "Венера"},
                {"Перл Бак", "Розалинд Франклин", "Мария Кюри", "Джейн Аддамс"}
        };
        Scanner console = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (int j = 0; j < answerOptions[i].length; j++) {
                System.out.println(answerOptions[i][j]);
            }
            String userAnswer = console.nextLine();
            if (userAnswer.equals(correctAnswers[i])) {
                correctCount++;
            } else {
                wrongCount++;
            }
        }

        System.out.println("Результат: правильно " + correctCount + ", неправильно " + wrongCount);
    }
}

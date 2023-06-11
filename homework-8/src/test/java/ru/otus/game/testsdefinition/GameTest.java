package ru.otus.game.testsdefinition;

import ru.otus.game.Dice;
import ru.otus.game.Game;
import ru.otus.game.GameWinnerPrinter;
import ru.otus.game.Player;
import ru.otus.game.assertions.Assertions;
import ru.otus.game.fakes.DiceSpy;
import ru.otus.game.fakes.GameWinnerPrinterSpy;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    public void testFirstPlayerWins() {
        String scenario = "Тест ситуации, когда первый игрок набирает больше очков";
        try {
            List<Object> actualFlow = new ArrayList<>();
            Dice diceSpy = new DiceSpy(actualFlow);
            GameWinnerPrinter winnerPrinterSpy = new GameWinnerPrinterSpy(actualFlow);
            Game game = new Game(diceSpy, winnerPrinterSpy);
            Player firstPlayer = new Player("First");
            Player secondPlayer = new Player("Second");
            List<Object> expectedFlow = List.of(
                    "roll вызван впервые",
                    "Выброшено число 6",
                    "roll вызван второй раз",
                    "Выброшено число 1",
                    "Победитель: First",
                    firstPlayer
            );

            game.playGame(firstPlayer, secondPlayer);

            Assertions.assertEquals(expectedFlow.size(), actualFlow.size());
            for (int i = 0; i < expectedFlow.size(); i++) {
                Assertions.assertEquals(expectedFlow.get(i), actualFlow.get(i));
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testSecondPlayerWins() {
        String scenario = "Тест ситуации, когда второй игрок набирает больше очков";
        try {
            List<Object> actualFlow = new ArrayList<>();
            Dice diceSpy = new DiceSpy(actualFlow);
            GameWinnerPrinter winnerPrinterSpy = new GameWinnerPrinterSpy(actualFlow);
            Game game = new Game(diceSpy, winnerPrinterSpy);
            Player firstPlayer = new Player("First");
            Player secondPlayer = new Player("Second");
            List<Object> expectedFlow = List.of(
                    "roll вызван впервые",
                    "Выброшено число 6",
                    "roll вызван второй раз",
                    "Выброшено число 1",
                    "Победитель: Second",
                    secondPlayer
            );

            game.playGame(secondPlayer, firstPlayer);

            Assertions.assertEquals(expectedFlow.size(), actualFlow.size());
            for (int i = 0; i < expectedFlow.size(); i++) {
                Assertions.assertEquals(expectedFlow.get(i), actualFlow.get(i));
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testSameNumberOfPoints() {
        String scenario = "Тест ситуации, когда игроки набирают одинаковое количество очков";
        try {
            List<Object> actualFlow = new ArrayList<>();
            Dice diceSpy = new DiceSpy(true, actualFlow);
            GameWinnerPrinter winnerPrinterSpy = new GameWinnerPrinterSpy(actualFlow);
            Game game = new Game(diceSpy, winnerPrinterSpy);
            Player firstPlayer = new Player("First");
            Player secondPlayer = new Player("Second");
            List<Object> expectedFlow = List.of(
                    "roll вызван впервые",
                    "Выброшено число 6",
                    "roll вызван второй раз",
                    "Выброшено число 6"
            );

            Assertions.assertThrows(RuntimeException.class, () -> game.playGame(firstPlayer, secondPlayer));

            Assertions.assertEquals(expectedFlow.size(), actualFlow.size());
            for (int i = 0; i < expectedFlow.size(); i++) {
                Assertions.assertEquals(expectedFlow.get(i), actualFlow.get(i));
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}

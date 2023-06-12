package ru.otus.game.runner;

import ru.otus.game.testsdefinition.DiceImplTest;
import ru.otus.game.testsdefinition.GameTest;

public class AllTests {
    public static void main(String[] args) {
        new DiceImplTest().testRangeOfPossibleValues();
        new GameTest().testFirstPlayerWins();
        new GameTest().testSecondPlayerWins();
        new GameTest().testSameNumberOfPoints();
    }
}

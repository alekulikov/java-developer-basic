package ru.otus.game.testsdefinition;

import ru.otus.game.Dice;
import ru.otus.game.DiceImpl;
import ru.otus.game.assertions.Assertions;

public class DiceImplTest {

    public void testRangeOfPossibleValues() {
        String scenario = "Тест выпадания чисел на кубике в диапозоне от 1 до 6";
        Dice dice = new DiceImpl();
        for (int i = 0; i < 10; i++) {
            try {
                int actual = dice.roll();
                Assertions.assertTrue(actual <= 6 && actual > 0);
            } catch (Throwable e) {
                System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
                return;
            }
        }
        System.out.printf("\"%s\" passed %n", scenario);
    }
}

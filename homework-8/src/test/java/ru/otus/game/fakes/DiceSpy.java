package ru.otus.game.fakes;

import ru.otus.game.Dice;

import java.util.List;

public class DiceSpy implements Dice {
    private final boolean constant;
    private final List<Object> actualFlow;
    private boolean isFirstInputCall = true;

    public DiceSpy(boolean constant, List<Object> actualFlow) {
        this.constant = constant;
        this.actualFlow = actualFlow;
    }

    public DiceSpy(List<Object> actualFlow) {
        this.constant = false;
        this.actualFlow = actualFlow;
    }

    @Override
    public int roll() {
        actualFlow.add("roll вызван " + (isFirstInputCall ? "впервые" : "второй раз"));

        if (constant || isFirstInputCall) {
            isFirstInputCall = false;
            actualFlow.add("Выброшено число 6");
            return 6;
        } else {
            actualFlow.add("Выброшено число 1");
            return 1;
        }
    }
}

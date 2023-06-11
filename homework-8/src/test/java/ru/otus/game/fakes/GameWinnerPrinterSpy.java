package ru.otus.game.fakes;

import ru.otus.game.GameWinnerPrinter;
import ru.otus.game.Player;

import java.util.List;

public class GameWinnerPrinterSpy implements GameWinnerPrinter {
    private final List<Object> actualFlow;

    public GameWinnerPrinterSpy(List<Object> actualFlow) {
        this.actualFlow = actualFlow;
    }

    @Override
    public void printWinner(Player winner) {
        actualFlow.add(String.format("Победитель: %s", winner.getName()));
        actualFlow.add(winner);
    }
}

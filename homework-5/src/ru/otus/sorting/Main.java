package ru.otus.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    private static final long SIZE_OF_LIST = 25_000L;
    private static final Random GENERATOR = new Random();

    public static void main(String[] args) {
        List<Integer> testListBubble = generateRandomNumbers();
        List<Integer> testListMerge = new ArrayList<>(testListBubble);

        long beginTime = System.currentTimeMillis();
        SortingAlgorithms.bubbleSort(testListBubble);
        System.out.println("Продолжительность пузырьковой сортировки: "
                + (System.currentTimeMillis() - beginTime) + "мс");

        beginTime = System.currentTimeMillis();
        Collections.sort(testListMerge);
        System.out.println("Продолжительность сортировки Collections.sort(): "
                + (System.currentTimeMillis() - beginTime) + "мс");
    }

    public static List<Integer> generateRandomNumbers() {
        return GENERATOR
                .ints(SIZE_OF_LIST, Integer.MIN_VALUE, Integer.MAX_VALUE)
                .boxed()
                .collect(Collectors.toList());
    }
}

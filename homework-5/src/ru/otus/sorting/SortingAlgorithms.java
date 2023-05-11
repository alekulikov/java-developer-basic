package ru.otus.sorting;

import java.util.List;
import java.util.ListIterator;

public class SortingAlgorithms {

    private SortingAlgorithms() {
    }

    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        Object[] array = list.toArray();
        ListIterator<T> iterator = list.listIterator();

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (((Comparable) array[j]).compareTo(array[j + 1]) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (Object element : array) {
            iterator.next();
            iterator.set((T) element);
        }
    }
}

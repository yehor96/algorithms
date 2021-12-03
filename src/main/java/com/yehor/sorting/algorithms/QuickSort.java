package com.yehor.sorting.algorithms;

public class QuickSort {

    public static String[] operateOn(String[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static void quickSort(String[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(array, start, end);

            quickSort(array, pivotIndex + 1, end);
            quickSort(array, start, pivotIndex - 1);
        }
    }

    private static int partition(String[] array, int start, int end) {
        String pivot = array[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                String temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }

        String temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;
        return i + 1;
    }

}

package com.yehor.algorithms;

public class SelectionSort {

    public static String[] operateOn(String[] array) {

        for (int i = 0; i < array.length; i++) {
            String firstString = array[i];
            int swapIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(firstString) < 0) {
                    firstString = array[j];
                    swapIndex = j;
                }
            }
            String temp = array[i];
            array[i] = firstString;
            array[swapIndex] = temp;
        }

        return array;
    }
}

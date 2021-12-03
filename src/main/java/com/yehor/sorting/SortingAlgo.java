package com.yehor.sorting;

import com.github.javafaker.Faker;
import com.yehor.sorting.algorithms.QuickSort;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SortingAlgo {

    private static final Faker faker = new Faker();
    private static final int SIZE = 10_000;

    public static void main(String[] args) {
        //displayWithTimer(() -> SelectionSort.operateOn(newArrayOf(SIZE)), "Selection Sort");
        //displayWithTimer(() -> BubbleSort.operateOn(newArrayOf(SIZE)), "Bubble Sort");
        displayWithTimer(() -> QuickSort.operateOn(newArrayOf(SIZE)), "Quick Sort");
    }

    private static String[] newArrayOf(int size) {
        return Stream.generate(() -> faker.gameOfThrones().character())
                .limit(size)
                .toArray(String[]::new);
    }

    private static void displayWithTimer(Supplier<String[]> operation, String name) {
        System.out.println("\n========================== " + name + " =========================================");
        var start = System.currentTimeMillis();
        System.out.println(Arrays.toString(operation.get()));
        var end = System.currentTimeMillis();
        System.out.println("Operation took: " + (end - start) + " ms.");
        System.out.println("===================================================================\n");
    }
}

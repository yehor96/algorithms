package com.yehor;

import com.github.javafaker.Faker;
import com.yehor.algorithms.BubbleSort;
import com.yehor.algorithms.SelectionSort;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SortingAlgo {

    private static final Faker faker = new Faker();
    private static final int SIZE = 100;

    public static void main(String[] args) {
        displayWithTimer(() -> SelectionSort.operateOn(newArrayOf(SIZE)), "Selection Sort");
        displayWithTimer(() -> BubbleSort.operateOn(newArrayOf(SIZE)), "Bubble Sort");
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

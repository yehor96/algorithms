package com.yehor;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.stream.Stream;

public class ContainsAlgo {

    public static void main(String[] args) {
        final int searched = 700_000;

        Faker faker = new Faker();
        int[] numbers = Stream.generate(() -> faker.number().numberBetween(0, 1_000_000_000))
                .limit(1_000_000)
                .mapToInt(i -> i)
                .toArray();
        numbers[0] = searched;
        Arrays.sort(numbers);

        long start = System.currentTimeMillis();

        boolean res =
                containsBinary(numbers, searched);
                //containsForLoop(numbers, searched);

        System.out.println("res: " + res);
        System.out.println("time: " + (System.currentTimeMillis() - start));
    }

    static boolean containsBinary(int[] array, int searched) {
        if (array.length == 1) {
            return array[0] == searched;
        } else {
            int[] newArray;
            int mid = array.length / 2;

            if (searched > array[mid]) {
                if (array.length == 2) {
                    newArray = new int[array.length - mid];
                } else {
                    newArray = new int[array.length - mid - 1];
                }
                System.arraycopy(array, mid + 1, newArray, 0, array.length - mid - 1);
            } else if (searched < array[mid]) {
                newArray = new int[mid];
                System.arraycopy(array, 0, newArray, 0, mid);
            } else {
                return true;
            }

            return containsBinary(newArray, searched);
        }
    }

    static boolean containsForLoop(int[] array, int searched) {
        for (int i : array) {
            if (i == searched) {
                return true;
            }
        }
        return false;
    }
}

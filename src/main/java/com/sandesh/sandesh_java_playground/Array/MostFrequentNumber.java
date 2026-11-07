package com.sandesh.sandesh_java_playground.Array;

import java.util.Arrays;
import java.util.HashMap;

public class MostFrequentNumber {
    public static void main(String[] args) {
        // NOTE: The following input values are used for testing your solution.

        // mostFrequent(array1) should return 1.
        int[] array1 = {1, 3, 1, 3, 2, 1};
        // mostFrequent(array2) should return 3.
        int[] array2 = {3, 3, 1, 3, 2, 1};
        // mostFrequent(array3) should return null.
        int[] array3 = {};
        // mostFrequent(array4) should return 0.
        int[] array4 = {0};
        // mostFrequent(array5) should return -1.
        int[] array5 = {0, -1, 10, 10, -1, 10, -1, -1, -1, 1};

        System.out.println("Input Array: " + Arrays.toString(array1) + ", Most Frequent Number: " +mostFrequent(array1)); //1
        System.out.println("Input Array: " + Arrays.toString(array2) + ", Most Frequent Number: " +mostFrequent(array2)); // 3
        System.out.println("Input Array: " + Arrays.toString(array3) + ", Most Frequent Number: " +mostFrequent(array3)); // null
        System.out.println("Input Array: " + Arrays.toString(array4) + ", Most Frequent Number: " +mostFrequent(array4)); // 0
        System.out.println("Input Array: " + Arrays.toString(array5) + ", Most Frequent Number: " +mostFrequent(array5)); // -1
    }

    public static Integer mostFrequent(int[] givenArray) {
        // Store each number and its frequency
        HashMap<Integer, Integer> count = new HashMap<>();
        Integer maxItem = null;
        int maxCount = 0;

        // Traverse the array
        for (int i : givenArray) {
            // Check if number already exists
            if (count.containsKey(i)) {
                // Increase its frequency by 1
                count.put(i, count.get(i) + 1);
            } else {
                // First occurrence of the number
                count.put(i, 1);
            }
            // Update maximum frequency
            if (count.get(i) > maxCount) {
                maxCount = count.get(i);
                maxItem = i;
            }
        }
        return maxItem;
    }
}

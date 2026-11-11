package com.sandesh.sandesh_java_playground.array;

import java.util.*;

//https://www.wscubetech.com/resources/java/programs/second-largest-number-array
public class SecondHighestWithStream {
    public static void main(String[] args) {
        int[] arr = {12, 45, 67, 89, 34};

        // Remove duplicates and sort in reverse
        // order
        OptionalInt result = Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)

                // Skip the largest
                .skip(1)
                .findFirst();

        System.out.println("Second Largest Number: " + (result.isPresent() ?
                result.getAsInt() : "Not found"));
    }
}
package com.sandesh.sandesh_java_playground.array;
import java.util.ArrayList;
import java.util.Arrays;

public class CommonElements {
    public static void main(String[] args) {
        // INPUT 1
        // First sorted array.
        int[] array1A = {1, 3, 4, 6, 7, 9};
        // Second sorted array.
        int[] array2A = {1, 2, 4, 5, 9, 10};
        // Expected common elements: [1, 4, 9]

        // INPUT 2
        int[] array1B = {1, 2, 9, 10, 11, 12};
        int[] array2B = {0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15};
        // Expected common elements: [1, 2, 9, 10, 12]

        // INPUT 3
        int[] array1C = {0, 1, 2, 3, 4, 5};
        int[] array2C = {6, 7, 8, 9, 10, 11};
        // Expected common elements: []

        // DISPLAY INPUTS AND OUTPUTS
        System.out.println("========== INPUT 1 ==========");
        // Display first input array.
        System.out.println("Array 1: " + Arrays.toString(array1A));
        // Display second input array.
        System.out.println("Array 2: " + Arrays.toString(array2A));
        // Call commonElements() and display the returned array.
        System.out.println("Output  : " + Arrays.toString(commonElements(array1A, array2A)));


        System.out.println("\n========== INPUT 2 ==========");
        System.out.println("Array 1: " + Arrays.toString(array1B));
        System.out.println("Array 2: " + Arrays.toString(array2B));
        System.out.println("Output  : " + Arrays.toString(commonElements(array1B, array2B)));

        System.out.println("\n========== INPUT 3 ==========");
        System.out.println("Array 1: " + Arrays.toString(array1C));
        System.out.println("Array 2: " + Arrays.toString(array2C));
        System.out.println("Output  : " + Arrays.toString(commonElements(array1C, array2C)));
    }

    // ==================================================
    // METHOD: FIND COMMON ELEMENTS BETWEEN TWO ARRAYS
    // ==================================================
    public static Integer[] commonElements(int[] array1, int[] array2) {

        // Pointer 1 starts at index 0 of the first array.
        int p1 = 0;

        // Pointer 2 starts at index 0 of the second array.
        int p2 = 0;

        // Create an empty ArrayList to store common elements.
        // We use ArrayList because its size can grow dynamically.
        ArrayList<Integer> result = new ArrayList<>();

        // Continue while BOTH pointers are within their array boundaries.
        // p1 < array1.length checks the first array.
        // p2 < array2.length checks the second array.
        // && means both conditions must be true.
        while (p1 < array1.length && p2 < array2.length) {

            // Compare the current elements of both arrays.
            // If they are equal, we found a common element.
            if (array1[p1] == array2[p2]) {
                // Add the common element to the result ArrayList.
                result.add(array1[p1]);
                // Move pointer 1 to the next index.
                p1++;
                // Move pointer 2 to the next index.
                p2++;

                // If the first array's current element is greater
                // than the second array's current element.
            } else if (array1[p1] > array2[p2]) {

                // Move pointer 2 forward because array2 has
                // the smaller element and is sorted.
                p2++;

                // Otherwise, the first array's current element
                // is smaller than the second array's current element.
            } else {
                // Move pointer 1 forward to find a bigger element.
                p1++;
            }
        }
        // Create an Integer array with the same size as the ArrayList.
        Integer[] resultInArray = new Integer[result.size()];

        // Convert the ArrayList into a regular Integer array.
        // Return the converted array to the calling method.
        return result.toArray(resultInArray);
    }
}

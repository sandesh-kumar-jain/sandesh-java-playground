
package com.sandesh.sandesh_java_playground.array;
import java.util.Arrays;

//Input is sorted array
public class MissingInteger {

    public int solution(int[] A) {

        int n = A.length;

        // Single-dimensional array
        int[] present = new int[n + 1];

        // Step 1: Mark existing positive numbers
        for (int i = 0; i < n; i++) {

            if (A[i] > 0 && A[i] <= n) {
                present[A[i]] = 1;
            }
        }

        // Step 2: Find the smallest missing positive number
        for (int i = 1; i <= n; i++) {

            if (present[i] == 0) {
                return i;
            }
        }

        return n + 1;
    }

    // Main method for testing
    public static void main(String[] args) {

        MissingInteger sol = new MissingInteger();

        int[] A1 = {1, 3, 6, 4, 1, 2};
        int[] A2 = {1, 2, 3};
        int[] A3 = {-1, -3};
        int[] A4 = {2, 3, 4, 5};
        int[] A5 = {1, 1, 2, 2};
        int[] A6 ={1000,5000 ,999999};

        System.out.println("Input: " + Arrays.toString(A1));
        System.out.println("Output: " + sol.solution(A1));

        System.out.println("Input: " + Arrays.toString(A2));
        System.out.println("Output: " + sol.solution(A2));

        System.out.println("Input: " + Arrays.toString(A3));
        System.out.println("Output: " + sol.solution(A3));

        System.out.println("Input: " + Arrays.toString(A4));
        System.out.println("Output: " + sol.solution(A4));

        System.out.println("Input: " + Arrays.toString(A5));
        System.out.println("Output: " + sol.solution(A5));

        System.out.println("Input: " + Arrays.toString(A6));
        System.out.println("Output: " + sol.solution(A6));
    }
}

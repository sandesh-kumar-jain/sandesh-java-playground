package com.sandesh.sandesh_java_playground.array;
//https://www.wscubetech.com/resources/java/programs/second-largest-number-array
public class SecondHighestNumber {

    public static void main(String[] args) {
        int[] arr = {12, 45, 67, 89, 34};

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {

                // Update both first and second
                second = first;
                first = num;
            } else if (num > second && num != first) {

                // Update second if it's less
                // and not equal to first
                second = num;
            }
        }
        System.out.println("Second Largest Number: " + second);
    }
}

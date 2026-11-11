package com.sandesh.sandesh_java_playground.string;

public class StringReverseManual {
    public static void main(String[] args) {
        String str = "Sandesh";
        System.out.println(reverseManual(str));
    }
    public static String reverseManual(String input) {
        char[] charArray = input.toCharArray();
        int left = 0, right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }
}

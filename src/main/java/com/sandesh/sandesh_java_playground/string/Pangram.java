package com.sandesh.sandesh_java_playground.string;
//https://www.geeksforgeeks.org/dsa/check-if-a-given-string-is-pangram-in-java/
public class Pangram {
    static void allLetter(String str) {
        str = str.toLowerCase();
        boolean allPresent = true;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!str.contains(String.valueOf(ch))) {
                allPresent = false;
                break;
            }
        }
        if (allPresent)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static void main(String[] args) {
        String str = "Abcdefghijklmnopqrstuvwxyz12";
        allLetter(str);
    }
}

/*Explanation:

The string is converted to lowercase to ignore case differences.
        A boolean variable allPresent assumes all letters are present initially.
A loop runs from 'a' to 'z' to check every alphabet letter.
        str.contains() checks whether each letter exists in the string.
If any letter is missing, allPresent is set to false and the loop stops.*/

package com.sandesh.sandesh_java_playground.string;
//https://medium.com/@mehar.chand.cloud/validating-anagrams-in-java-4c0152b8634c
//https://chatgpt.com/uc/6af34798-d208-83ea-aa78-c083d9eb12a3
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        System.out.println(va.isAnagram("anagram", "nagaram"));
        // Output: true

        System.out.println(va.isAnagram("rat", "car"));
        // Output: false
    }
}
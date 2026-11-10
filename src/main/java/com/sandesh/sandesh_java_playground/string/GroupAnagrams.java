package com.sandesh.sandesh_java_playground.string;
import java.util.*;
//https://algocademy.com/link/?lang=java&problem=group-anagrams&solution=1
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store the grouped anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through each string in the input array
        for (String s : strs) {
            // Convert the string to a character array and sort it
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            // Convert the sorted character array back to a string
            String sortedString = new String(charArray);

            // If the sorted string is not in the map, add it with a new list
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }
            // Add the original string to the list corresponding to the sorted string
            map.get(sortedString).add(s);
        }

        // Return the values of the map as the result
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(ga.groupAnagrams(input));
    }
}
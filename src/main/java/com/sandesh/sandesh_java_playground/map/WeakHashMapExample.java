package com.sandesh.sandesh_java_playground.map;
import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapExample {
    public static void main(String[] args) {
        // Creating WeakHashMap of numbers
        WeakHashMap<String, Integer> numbers = new WeakHashMap();

        String two = new String("Two");
        Integer twoValue = 2;
        String four = new String("Four");
        Integer fourValue = 4;

        // Inserting elements
        numbers.put(two, twoValue);
        numbers.put(four, fourValue);
        System.out.println("WeakHashMap: " + numbers);

        // Make the reference null
        two = null;

        // Perform garbage collection
        System.gc();

        System.out.println("WeakHashMap after garbage collection: " + numbers);
        System.out.println("======================================");
        // Creating WeakHashMap of numbers
        HashMap<String, Integer> hashMap = new HashMap();

        String twoHashMap = new String("Two");
        Integer twoValueHashMap = 2;
        String fourHashMap = new String("Four");
        Integer fourValueHashMap = 4;

        // Inserting elements
        hashMap.put(twoHashMap, twoValueHashMap);
        hashMap.put(fourHashMap, fourValueHashMap);
        System.out.println("HashMap: " + hashMap);

        // Make the reference null
        two = null;

        // Perform garbage collection
        System.gc();

        System.out.println("HashMap after garbage collection: " + hashMap);


    }
}

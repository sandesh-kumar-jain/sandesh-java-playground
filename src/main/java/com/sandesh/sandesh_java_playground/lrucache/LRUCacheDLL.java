// Java program to implement LRU Least Recently Used) using
// Built-in Doubly linked list
// https://www.geeksforgeeks.org/dsa/lru-cache-implementation-using-double-linked-lists/
package com.sandesh.sandesh_java_playground.lrucache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

class LRUCacheDLL {

    private final int capacity;

    // Stores key-value pairs
    private final Map<Integer, String> cacheMap;

    // Maintains access order: MRU -> LRU
    private final LinkedList<Integer> lruList;

    // Constructor
    public LRUCacheDLL(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }

        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.lruList = new LinkedList<>();
    }

    // Get value and mark key as most recently used
    public String get(int key) {

        String value = cacheMap.get(key);

        if (value == null) {
            return null;
        }

        // Remove key from its current position
        lruList.remove(Integer.valueOf(key));

        // Move key to MRU position
        lruList.addFirst(key);

        return value;
    }

    // Insert or update key-value pair
    public void put(int key, String value) {
        Objects.requireNonNull(value, "Null values are not allowed");

        if (cacheMap.containsKey(key)) {

            // Update existing value
            cacheMap.put(key, value);

            // Remove key from its current position
            lruList.remove(Integer.valueOf(key));

        } else {

            // Check capacity before inserting
            if (cacheMap.size() == capacity) {

                // Remove least recently used key
                int leastUsedKey = lruList.removeLast();

                // Remove corresponding map entry
                cacheMap.remove(leastUsedKey);
            }

            // Insert new key-value pair
            cacheMap.put(key, value);
        }

        // Mark inserted/updated key as MRU
        lruList.addFirst(key);
    }

    // Return current cache size
    public int size() {
        return cacheMap.size();
    }

    // Check whether cache is empty
    public boolean isEmpty() {
        return cacheMap.isEmpty();
    }

    // Display cache contents
    public void display() {
        System.out.println("Cache Map : " + cacheMap);
        System.out.println("LRU List (MRU -> LRU) : " + lruList);
    }

    public static void main(String[] args) {
        LRUCacheDLL cache = new LRUCacheDLL(2);

        // Step 1: Insert elements
        System.out.println("=== Insert Elements ===");
        cache.put(1, "A");
        cache.put(2, "B");
        cache.display();

        // Step 2: Access key 1
        System.out.println("\n=== Access Key 1 ===");
        System.out.println("get(1): " + cache.get(1));
        cache.display();

        // Step 3: Insert key 3 (evicts key 2)
        System.out.println("\n=== Insert Key 3 ===");
        cache.put(3, "C");
        cache.display();

        // Step 4: Verify eviction
        System.out.println("\n=== Verify Eviction ===");
        System.out.println("get(2): " + cache.get(2));
        cache.display();

        // Step 5: Insert key 4 (evicts key 1)
        System.out.println("\n=== Insert Key 4 ===");
        cache.put(4, "D");
        cache.display();

        // Step 6: Final cache access
        System.out.println("\n=== Final Cache Access ===");
        System.out.println("get(1): " + cache.get(1));
        System.out.println("get(3): " + cache.get(3));
        System.out.println("get(4): " + cache.get(4));
        cache.display();

        System.out.println("\nCache Size: " + cache.size());
    }
}

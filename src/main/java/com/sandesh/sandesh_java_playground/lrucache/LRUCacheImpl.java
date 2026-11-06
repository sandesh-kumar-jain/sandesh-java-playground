package com.sandesh.sandesh_java_playground.lrucache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheImpl {
    private int capacity;

    // Stores key-value pairs
    private Map<Integer, String> cacheMap;

    // Stores keys in the order of access
    private LinkedList<Integer> lruList;

    // Constructor to initialize the cache with a given
    // capacity
    LRUCacheImpl(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.lruList = new LinkedList<>();
    }

    // Function to get the value for a given key
    public String get(int key) {
        String value = cacheMap.get(key);

        if (value == null) {
            return null;
        }
        // Move the accessed key to the front (most recently
        // used position)
        lruList.remove(Integer.valueOf(key));
        // Add key to the front
        lruList.addFirst(key);

        return value;
    }

    // Function to put a key-value pair into the cache
    public void put(int key, String value) {
        if (cacheMap.containsKey(key)) {

            // Update the value
            cacheMap.put(key, value);

            // Move the accessed key to the front
            lruList.remove(Integer.valueOf(key));
        } else {

            // Add new key-value pair
            if (cacheMap.size() >= capacity) {

                // Remove the least recently used item
                int leastUsedKey = lruList.removeLast();
                cacheMap.remove(leastUsedKey);
            }
            cacheMap.put(key, value);
        }
        // Add the key to the front (most recently used
        // position)
        lruList.addFirst(key);
    }

    public static void main(String[] args) {

        LRUCacheImpl cache = new LRUCacheImpl(2);

        // Step 1: Insert elements
        System.out.println("=== Insert Elements ===");
        cache.put(1, "A");
        cache.put(2, "B");
        printCache(cache);

        // Step 2: Access key 1 (makes it MRU)
        System.out.println("\n=== Access Key 1 ===");
        System.out.println("get(1): " + cache.get(1));
        printCache(cache);

        // Step 3: Insert key 3 (evicts LRU key 2)
        System.out.println("\n=== Insert Key 3 ===");
        cache.put(3, "C");
        printCache(cache);

        // Step 4: Verify key 2 was evicted
        System.out.println("\n=== Verify Eviction ===");
        System.out.println("get(2): " + cache.get(2));
        printCache(cache);

        // Step 5: Insert key 4 (evicts LRU key 1)
        System.out.println("\n=== Insert Key 4 ===");
        cache.put(4, "D");
        printCache(cache);

        // Step 6: Verify remaining elements
        System.out.println("\n=== Final Cache Access ===");
        System.out.println("get(1): " + cache.get(1));
        System.out.println("get(3): " + cache.get(3));
        System.out.println("get(4): " + cache.get(4));

        printCache(cache);
    }
    private static void printCache(LRUCacheImpl cache) {
        System.out.println("Cache Map: " + cache.cacheMap);
        System.out.println("LRU List (MRU → LRU): " + cache.lruList);
    }
}
package com.sandesh.sandesh_java_playground.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU (Least Recently Used) Cache implementation
 * using Java's LinkedHashMap.
 * <p>
 * The cache automatically removes the least recently
 * used entry when its capacity is exceeded.
 */
public class LRUCacheLinkedHashMap {

    // Maximum number of entries allowed in the cache.
    private final int capacity;

    // LinkedHashMap stores key-value pairs.
    // The third constructor argument (true) enables access-order.
    private final LinkedHashMap<Integer, String> cache;

    public LRUCacheLinkedHashMap(int capacity) {

        // Step 1: Validate the cache capacity.
        // Capacity must be greater than zero.
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }

        // Step 2: Store the maximum capacity.
        this.capacity = capacity;

        // Step 3: Initialize LinkedHashMap.
        this.cache = new LinkedHashMap<Integer, String>(capacity,       // Initial capacity
                0.75f,          // Load factor
                true            // Enable access-order (LRU behavior)
        ) {
            /**
             * Step 4: Override removeEldestEntry().
             * Java automatically calls this method after inserting a new entry.
             * If the cache size exceeds the given capacity, the eldest (least recently used) entry is removed.
             */
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > LRUCacheLinkedHashMap.this.capacity;
            }
        };
    }

    public synchronized String get(int key) {
        return cache.get(key);
    }

    public synchronized void put(int key, String value) {
        cache.put(key, value);
    }

    public synchronized void display() {
        System.out.println(cache);
    }

    /**
     * Step 8: Main method to test the LRU Cache.
     */
    public static void main(String[] args) {

        // Create an LRU cache with maximum capacity of 2.
        LRUCacheLinkedHashMap cache = new LRUCacheLinkedHashMap(2);

        // Insert key-value pairs.
        cache.put(1, "A");
        cache.put(2, "B");

        // Access key 1.
        // Key 1 becomes most recently used.
        System.out.println(cache.get(1));

        // Insert key 3.
        // Cache is full, so key 2 is removed
        // because it is the least recently used.
        cache.put(3, "C");

        // Display remaining entries.
        cache.display();
    }
}
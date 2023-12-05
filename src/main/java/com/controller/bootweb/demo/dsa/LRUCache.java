package com.controller.bootweb.demo.dsa;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);

        lruCache.put(1, "One");
        lruCache.put(2, "Two");
        lruCache.put(3, "Three");

        System.out.println(lruCache); // 输出：{1=One, 2=Two, 3=Three}

        lruCache.get(2); // 访问 2，使其变为最近使用，不会触发 removeEldestEntry

        lruCache.put(4, "Four"); // 添加 4，会触发 removeEldestEntry，将最久未使用的元素移除

        System.out.println(lruCache); // 输出：{2=Two, 3=Three, 4=Four}
    }
}


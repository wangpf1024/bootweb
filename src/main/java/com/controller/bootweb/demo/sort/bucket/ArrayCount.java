package com.controller.bootweb.demo.sort.bucket;

import java.util.HashMap;
import java.util.Map;

public class ArrayCount {

    public static Map<Integer, Integer> countOccurrences(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : array) {
            // If the number is already in the map, increment its count
            // Otherwise, add the number to the map with a count of 1
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 1, 2, 2, 3, 4, 5};

        System.out.println("原始数组：");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        Map<Integer, Integer> frequencyMap = countOccurrences(array);

        System.out.println("元素出现次数：");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "次");
        }
    }
}

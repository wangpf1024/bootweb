package com.controller.bootweb.demo.sort.bucket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static void bucketSort(float[] array) {
        int n = array.length;

        if (n <= 0) {
            return; // Nothing to sort
        }

        // Create buckets
        List<Float>[] buckets = new List[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute elements into buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * array[i]);
            buckets[bucketIndex].add(array[i]);
        }

        // Sort each bucket
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatenate the buckets
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float num : buckets[i]) {
                array[index++] = num;
            }
        }
    }

    public static void printArray(float[] array) {
        for (float num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        float[] array = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};

        System.out.println("未排序数组：");
        printArray(array);

        bucketSort(array);

        System.out.println("桶排序后的数组：");
        printArray(array);
    }
}


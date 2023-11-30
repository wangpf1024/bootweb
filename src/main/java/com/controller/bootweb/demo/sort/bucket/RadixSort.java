package com.controller.bootweb.demo.sort.bucket;

import java.util.Arrays;

public class RadixSort {

    public static void radixSort(int[] array) {
        // Find the maximum number to know the number of digits
        int max = Arrays.stream(array).max().orElse(0);

        // Do counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    private static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        // Count the occurrences of each digit at the current place value
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Modify count[i] to store the position of the next occurrence
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the output array back to the original array
        System.arraycopy(output, 0, array, 0, n);
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("未排序数组：");
        printArray(array);

        radixSort(array);

        System.out.println("基数排序后的数组：");
        printArray(array);
    }
}


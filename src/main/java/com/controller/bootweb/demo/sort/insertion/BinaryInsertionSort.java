package com.controller.bootweb.demo.sort.insertion;

public class BinaryInsertionSort {

    public static void binaryInsertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];

            // Find the position to insert using binary search
            int position = binarySearch(array, key, 0, i - 1);

            // Shift elements to make space for the key
            System.arraycopy(array, position, array, position + 1, i - position);

            // Insert the key at the correct position
            array[position] = key;
        }
    }

    private static int binarySearch(int[] array, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};

        System.out.println("未排序数组：");
        printArray(array);

        binaryInsertionSort(array);

        System.out.println("Binary Insertion Sort 后的数组：");
        printArray(array);
    }
}


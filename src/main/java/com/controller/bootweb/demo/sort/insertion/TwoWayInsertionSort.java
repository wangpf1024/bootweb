package com.controller.bootweb.demo.sort.insertion;

public class TwoWayInsertionSort {

    public static void twoWayInsertionSort(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            // Move from left to right
            for (int i = left + 1; i <= right; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                }
            }
            right--;

            // Move from right to left
            for (int i = right; i >= left; i--) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                }
            }
            left++;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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

        twoWayInsertionSort(array);

        System.out.println("Two-Way Insertion Sort 后的数组：");
        printArray(array);
    }
}


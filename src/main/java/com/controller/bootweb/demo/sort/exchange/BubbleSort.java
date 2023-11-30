package com.controller.bootweb.demo.sort.exchange;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // 如果当前元素大于下一个元素，则交换它们
                if (array[j] > array[j + 1]) {
                    // 交换array[j]和array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("未排序数组：");
        printArray(array);

        bubbleSort(array);

        System.out.println("冒泡排序后的数组：");
        printArray(array);
    }
}

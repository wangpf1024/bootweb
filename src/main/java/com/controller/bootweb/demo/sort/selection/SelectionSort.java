package com.controller.bootweb.demo.sort.selection;

public class SelectionSort {

    public static void selectionSort(int[] array) {
        int n = array.length;

        // 遍历数组
        for (int i = 0; i < n - 1; i++) {
            // 找到未排序部分的最小元素的索引
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // 将找到的最小元素与未排序部分的第一个元素交换位置
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        System.out.println("未排序数组：");
        printArray(array);

        selectionSort(array);

        System.out.println("简单选择排序后的数组：");
        printArray(array);
    }
}


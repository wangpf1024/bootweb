package com.controller.bootweb.demo.sort.insertion;

public class InsertionSort {

    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int currentElement = array[i];
            int j = i - 1;

            // 移动已排序部分中的元素，找到适当的位置插入当前元素
            while (j >= 0 && array[j] > currentElement) {
                array[j + 1] = array[j];
                j--;
            }

            // 插入当前元素到正确的位置
            array[j + 1] = currentElement;
        }
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

        insertionSort(array);

        System.out.println("插入排序后的数组：");
        printArray(array);
    }
}


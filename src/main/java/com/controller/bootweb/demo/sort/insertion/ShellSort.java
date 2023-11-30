package com.controller.bootweb.demo.sort.insertion;

public class ShellSort {

    public static void shellSort(int[] array) {
        int n = array.length;

        // 初始步长设定为数组长度的一半，并逐渐减小步长
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 从步长位置开始，对每个子数组进行插入排序
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;

                // 插入排序的逻辑，与插入排序类似但步长为gap
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = temp;
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
        int[] array = {12, 34, 54, 2, 3};

        System.out.println("未排序数组：");
        printArray(array);

        shellSort(array);

        System.out.println("希尔排序后的数组：");
        printArray(array);
    }
}


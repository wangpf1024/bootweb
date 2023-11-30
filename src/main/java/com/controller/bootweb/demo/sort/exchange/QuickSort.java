package com.controller.bootweb.demo.sort.exchange;

public class QuickSort {

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // 划分数组，返回基准元素的索引
            int pivotIndex = partition(array, low, high);

            // 递归地对基准元素左右两侧的子数组进行排序
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        // 选择最右侧元素作为基准
        int pivot = array[high];

        // 索引i用于跟踪小于基准的元素的位置
        int i = low - 1;

        // 从左到右遍历数组，将小于基准的元素交换到数组的左侧
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // 交换array[i]和array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // 将基准元素放到正确的位置
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // 返回基准元素的索引
        return i + 1;
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

        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);

        System.out.println("快速排序后的数组：");
        printArray(array);
    }
}


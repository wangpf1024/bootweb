package com.controller.bootweb.demo.sort;

public class MergeSort {

    public static void mergeSort(int[] array) {
        int n = array.length;

        if (n > 1) {
            // 将数组分为两半
            int mid = n / 2;
            int[] left = new int[mid];
            int[] right = new int[n - mid];

            System.arraycopy(array, 0, left, 0, mid);
            System.arraycopy(array, mid, right, 0, n - mid);

            // 递归地对两个子数组进行排序
            mergeSort(left);
            mergeSort(right);

            // 合并已排序的两个子数组
            merge(array, left, right);
        }
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // 比较左右子数组的元素，并将较小的元素放入原数组
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // 将左子数组中剩余的元素复制到原数组
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // 将右子数组中剩余的元素复制到原数组
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("未排序数组：");
        printArray(array);

        mergeSort(array);

        System.out.println("归并排序后的数组：");
        printArray(array);
    }
}


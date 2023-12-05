package com.controller.bootweb.demo.dsa;

public class ArrayWithSentinel {

    public static int findElement(int[] arr, int target) {
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[arr.length] = target;  // 哨兵元素

        int index = 0;
        while (newArr[index] != target) {
            index++;
        }

        return index == arr.length ? -1 : index;
    }

    public static void main(String[] args) {
        // 示例：查找数组中的元素
        int[] array = {1, 2, 3, 4, 5};
        int target = 3;

        int result = findElement(array, target);
        System.out.println("Index of " + target + ": " + result);
    }
}

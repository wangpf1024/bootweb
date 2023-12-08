package com.controller.bootweb.demo.dsa;

public class BinarySearchVariation {

    // 二分查找变种：查找第一个出现的元素的索引
    public static int findFirstOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int result = -1;  // 初始化为-1，表示未找到

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                result = mid;  // 更新结果，但不停止搜索，继续向左查找第一个出现的元素
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 2, 4, 4, 4, 5, 6, 7};
        int target = 4;

        int result = findFirstOccurrence(sortedArray, target);

        if (result != -1) {
            System.out.println("The first occurrence of " + target + " is at index " + result);
        } else {
            System.out.println(target + " is not found in the array.");
        }
    }
}



package com.controller.bootweb.demo.dsa;

public class BinarySearchVariation2 {

    // 二分查找变种：查找最后一个出现的元素的索引
    public static int findLastOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int result = -1;  // 初始化为-1，表示未找到

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                result = mid;  // 更新结果，但不停止搜索，继续向右查找最后一个出现的元素
                low = mid + 1;
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

        int result = findLastOccurrence(sortedArray, target);

        if (result != -1) {
            System.out.println("The last occurrence of " + target + " is at index " + result);
        } else {
            System.out.println(target + " is not found in the array.");
        }
    }
}



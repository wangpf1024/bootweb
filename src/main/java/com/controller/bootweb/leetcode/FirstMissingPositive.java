package com.controller.bootweb.leetcode;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 第一次遍历：将数组元素移动到正确的位置上
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // 将 nums[i] 放到正确的位置上
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // 第二次遍历：找到第一个不在正确位置上的正整数
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果数组已经是连续的正整数，返回 n + 1
        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive solution = new FirstMissingPositive();
        int[] nums = {3, 4, -1, 1};
        int result = solution.firstMissingPositive(nums);
        System.out.println("First Missing Positive: " + result);
    }
}

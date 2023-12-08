package com.controller.bootweb.demo.dsa;

public class FirstMissingPositive {

    // 寻找缺失的第一个正数
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 将每个数字放到正确的位置，使得 nums[i] == i + 1
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 查找第一个位置不满足 nums[i] == i + 1 的数字
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果数组中的所有数字都满足条件，则返回 n + 1
        return n + 1;
    }

    // 交换数组中两个元素的位置
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};

        int missingPositive = firstMissingPositive(nums);

        System.out.println("The first missing positive is: " + missingPositive);
    }
}

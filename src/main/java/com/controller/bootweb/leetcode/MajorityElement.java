package com.controller.bootweb.leetcode;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        // Boyer-Moore投票算法
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        int[] nums = {3, 3, 4, 2, 2, 3, 3};
        int result = solution.majorityElement(nums);
        System.out.println("Majority Element: " + result);
    }
}


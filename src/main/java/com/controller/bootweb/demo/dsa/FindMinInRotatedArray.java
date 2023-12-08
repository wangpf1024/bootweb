package com.controller.bootweb.demo.dsa;

public class FindMinInRotatedArray {

    // 在循环排序数组中查找最小值
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // 最小值可能在右侧
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // 最小值可能在左侧（包括 mid 本身）
                right = mid;
            } else {
                // 无法确定在左侧还是右侧，缩小搜索范围
                right--;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] rotatedArray = {4, 5, 6, 7, 0, 1, 2};

        int minValue = findMin(rotatedArray);

        System.out.println("The minimum value in the rotated array is: " + minValue);
    }
}


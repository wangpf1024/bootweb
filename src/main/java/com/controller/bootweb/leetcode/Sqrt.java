package com.controller.bootweb.leetcode;

public class Sqrt {

    public int mySqrt(int x) {
        // 边界条件处理
        if (x == 0 || x == 1) {
            return x;
        }

        // 二分查找
        int left = 1, right = x / 2;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            // 更新左边界或右边界，并保留整数部分作为候选结果
            if (square == x) {
                return mid;
            } else if (square < x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Sqrt solution = new Sqrt();

        // 测试
        System.out.println(solution.mySqrt(4)); // 输出: 2
        System.out.println(solution.mySqrt(8)); // 输出: 2
        System.out.println(solution.mySqrt(16)); // 输出: 4
    }
}


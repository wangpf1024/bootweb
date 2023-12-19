package com.controller.bootweb.leetcode;
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        // 测试
        System.out.println(solution.climbStairs(2)); // 输出: 2
        System.out.println(solution.climbStairs(3)); // 输出: 3
        System.out.println(solution.climbStairs(4)); // 输出: 5
    }
}


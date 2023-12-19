package com.controller.bootweb.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        // 遍历数组
        for (int i = 0; i < n; i++) {
            // 移除超出窗口范围的元素
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 保持队列单调递减
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // 将当前元素加入队列
            deque.offerLast(i);

            // 记录窗口最大值
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();

        // 示例
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);

        // 输出结果
        for (int num : result) {
            System.out.print(num + " ");
        }
        // 输出: [3, 3, 5, 5, 6, 7]
    }
}

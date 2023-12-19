package com.controller.bootweb.leetcode;

import java.util.Stack;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // 栈为空，表示没有匹配的左括号，将当前右括号的位置入栈
                    stack.push(i);
                } else {
                    // 计算当前位置与栈顶元素之间的距离，更新最长有效括号子串的长度
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();

        // 测试字符串
        System.out.println(solution.longestValidParentheses("(()")); // 输出: 2
        System.out.println(solution.longestValidParentheses(")()())")); // 输出: 4
    }
}



package com.controller.bootweb.demo.dsa;

import java.util.Stack;

public class RemoveKDigits {

    /**
     * 1. **初始化一个空栈，用于存放最终结果的数字。**
     * 2. 从高位到低位遍历非负整数 a 的每一位。
     *    - 如果栈不为空，且当前数字小于栈顶数字，弹出栈顶数字，直到栈为空或者已经移除 k 个数字。
     *    - 将当前数字入栈。
     * 3. **如果仍需移除 k 个数字，从栈底开始弹出数字，直到移除 k 个数字。**
     * 4. **构造最终的结果字符串。**
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || k >= num.length()) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && digit < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // 如果仍需移除 k 个数字，从栈底开始弹出数字
        while (k > 0) {
            stack.pop();
            k--;
        }

        // 构造最终结果字符串
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        // 移除结果字符串前导的 '0'
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        result.delete(0, index);

        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 4;
        String result = removeKdigits(num, k);
        System.out.println(result); // Output: "1219"
    }
}


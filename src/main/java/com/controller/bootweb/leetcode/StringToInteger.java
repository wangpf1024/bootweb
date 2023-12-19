package com.controller.bootweb.leetcode;

public class StringToInteger {

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // 去除前导空格
        s = s.trim();

        if (s.isEmpty()) {
            return 0;
        }

        // 处理符号位
        int sign = 1;
        int index = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            index++;
        }

        // 转换数字
        int result = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // 处理溢出
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        StringToInteger solution = new StringToInteger();

        // 测试
        System.out.println(solution.myAtoi("42")); // 输出: 42
        System.out.println(solution.myAtoi("   -42")); // 输出: -42
        System.out.println(solution.myAtoi("4193 with words")); // 输出: 4193
        System.out.println(solution.myAtoi("words and 987")); // 输出: 0
        System.out.println(solution.myAtoi("-91283472332")); // 输出: -2147483648
    }
}


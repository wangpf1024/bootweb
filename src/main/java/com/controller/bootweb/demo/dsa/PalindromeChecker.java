package com.controller.bootweb.demo.dsa;

import java.util.Stack;

import java.util.Stack;

import java.util.Stack;

import java.util.Stack;

public class PalindromeChecker {

    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return true; // 空字符串是回文串
        }

        // 将字符串中的非字母和非数字字符去除，并转换为小写
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int length = str.length();
        Stack<Character> stack = new Stack<>();

        // 将字符串的前半部分压入栈中
        for (int i = 0; i < length / 2; i++) {
            stack.push(str.charAt(i));
        }

        // 跳过字符串中间的字符，如果字符串长度为奇数
        int startIndex = (length % 2 == 0) ? length / 2 : length / 2 + 1;

        // 比较栈中的字符与字符串后半部分的字符是否相同
        for (int i = startIndex; i < length; i++) {
            if (stack.isEmpty() || stack.pop() != str.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // 示例
        String palindrome1 = "A man, a plan, a canal, Panama!";
        String palindrome2 = "Race a car";
        String palindrome3 = "abcba";

        System.out.println(isPalindrome(palindrome1)); // 输出 true
        System.out.println(isPalindrome(palindrome2)); // 输出 false
        System.out.println(isPalindrome(palindrome3)); // 输出 true
    }
}



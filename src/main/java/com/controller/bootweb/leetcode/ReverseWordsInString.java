package com.controller.bootweb.leetcode;

public class ReverseWordsInString {

    public String reverseWords(String s) {
        // 去除多余空格并分割字符串为单词数组
        String[] words = s.trim().split("\\s+");

        // 反转单词数组
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInString solution = new ReverseWordsInString();

        // 测试
        System.out.println(solution.reverseWords("the sky is blue")); // 输出: "blue is sky the"
        System.out.println(solution.reverseWords("  hello world  ")); // 输出: "world hello"
        System.out.println(solution.reverseWords("a good   example")); // 输出: "example good a"
    }
}

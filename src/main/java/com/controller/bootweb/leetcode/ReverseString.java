package com.controller.bootweb.leetcode;

public class ReverseString {

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;

        while (left < right) {
            // 交换元素
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // 移动指针
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();

        // 测试
        char[] str1 = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(str1);
        System.out.println(str1); // 输出: "olleh"

        char[] str2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        solution.reverseString(str2);
        System.out.println(str2); // 输出: "hannaH"
    }
}

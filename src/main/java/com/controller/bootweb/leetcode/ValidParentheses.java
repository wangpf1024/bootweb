package com.controller.bootweb.leetcode;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false; // 右括号多于左括号
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false; // 括号类型不匹配
                }
            }
        }

        return stack.isEmpty(); // 栈为空表示所有左括号都找到了匹配的右括号
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        // 测试有效字符串
        System.out.println(solution.isValid("()")); // true
        System.out.println(solution.isValid("()[]{}")); // true
        System.out.println(solution.isValid("{[()]}")); // true

        // 测试无效字符串
        System.out.println(solution.isValid("(]")); // false
        System.out.println(solution.isValid("([)]")); // false
        System.out.println(solution.isValid("{{{{")); // false
    }
}


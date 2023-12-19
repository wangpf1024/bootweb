package com.controller.bootweb.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = evaluate(token, operand1, operand2);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    private int evaluate(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                // 需要注意被除数不能为0
                if (operand2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();

        // 测试逆波兰表达式
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println(solution.evalRPN(tokens1)); // 输出: 9

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(solution.evalRPN(tokens2)); // 输出: 6

        String[] tokens3 = {"10", "6", "9", "3", "/", "-", "*"};
        System.out.println(solution.evalRPN(tokens3)); // 输出: 15
    }
}

package com.controller.bootweb.demo.dsa;

import java.util.Arrays;
import java.util.Comparator;

import java.util.Arrays;
import java.util.Comparator;

public class CustomSort2 {

    public static void main(String[] args) {
        String input = "D3aF9Bc1Az";

        Character[] charArray = input.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        // 对字符数组进行排序，使用自定义的 Comparator
        Arrays.sort(charArray, Comparator.comparingInt((Character c) -> {
            if (Character.isLowerCase(c)) {
                return 0;
            } else if (Character.isDigit(c)) {
                return 1;
            } else {
                return 2;
            }
        }).thenComparingInt(Character::toLowerCase));

        String result = Arrays.toString(charArray);
        System.out.println(result); // 输出：acfz1349DBA
    }
}



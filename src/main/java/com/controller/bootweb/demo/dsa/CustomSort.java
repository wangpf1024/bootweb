package com.controller.bootweb.demo.dsa;

import java.util.Arrays;
import java.util.Comparator;

public class CustomSort {

    public static void main(String[] args) {
        String input = "DaFBcAz";

        Character[] charArray = input.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        // 对字符数组进行排序，使用自定义的 Comparator
        Arrays.sort(charArray, Comparator.comparingInt((Character c) -> Character.toLowerCase(c))
                .thenComparingInt(Character::getNumericValue));

        String result = Arrays.toString(charArray);
        System.out.println(result); // 输出：aBcDFAz
    }
}


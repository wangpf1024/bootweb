package com.controller.bootweb.demo.dsa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonStringsFinder {

    public static void main(String[] args) {
        // 两个字符串数组
        String[] array1 = {"apple", "banana", "orange", "kiwi", "grape"};
        String[] array2 = {"kiwi", "grape", "watermelon", "apple", "pear"};

        // 找出相同的字符串
        String[] commonStrings = findCommonStrings(array1, array2);

        // 输出结果
        System.out.println("Common Strings: " + Arrays.toString(commonStrings));
    }

    // 找出两个数组中相同的字符串
    private static String[] findCommonStrings(String[] array1, String[] array2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(array1));
        Set<String> set2 = new HashSet<>(Arrays.asList(array2));

        // 使用retainAll方法找出两个集合的交集
        set1.retainAll(set2);

        // 将交集转换为数组
        String[] commonStrings = set1.toArray(new String[0]);

        return commonStrings;
    }
}

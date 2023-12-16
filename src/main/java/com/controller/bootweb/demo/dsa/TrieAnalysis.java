package com.controller.bootweb.demo.dsa;

import java.util.HashSet;
import java.util.Set;

public class TrieAnalysis {
    // 统计字符集大小
    private static int calculateCharacterSetSize(Set<String> strings) {
        Set<Character> charSet = new HashSet<>();
        for (String str : strings) {
            for (char c : str.toCharArray()) {
                charSet.add(c);
            }
        }
        return charSet.size();
    }

    // 计算最长公共前缀长度
    private static int calculateAverageLCP(Set<String> strings) {
        int totalLCP = 0;
        int totalPairs = 0;

        for (String str1 : strings) {
            for (String str2 : strings) {
                if (!str1.equals(str2)) {
                    int lcp = longestCommonPrefix(str1, str2);
                    totalLCP += lcp;
                    totalPairs++;
                }
            }
        }

        return totalPairs > 0 ? totalLCP / totalPairs : 0;
    }

    // 计算两个字符串的最长公共前缀长度
    private static int longestCommonPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        int i;
        for (i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        // 添加字符串到集合中
        stringSet.add("ABABDABACDABABCABAB");
        stringSet.add("ABABCABAB");

        int charSetSize = calculateCharacterSetSize(stringSet);
        int averageLCP = calculateAverageLCP(stringSet);

        System.out.println("Character Set Size: " + charSetSize);
        System.out.println("Average Longest Common Prefix: " + averageLCP);
    }
}

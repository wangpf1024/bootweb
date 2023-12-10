package com.controller.bootweb.demo.dsa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class URLSorter {

    public static void main(String[] args) {
        String logFilePath = "/Users/arvin/workspace/logs/access.log";

        try {
            Map<String, Integer> urlCounts = countURLVisits(logFilePath);
            List<Map.Entry<String, Integer>> sortedURLs = sortURLsByVisits(urlCounts);

            // 输出排序后的结果
            for (Map.Entry<String, Integer> entry : sortedURLs) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " visits");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 读取日志文件并统计访问次数
    private static Map<String, Integer> countURLVisits(String logFilePath) throws IOException {
        Map<String, Integer> urlCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String url = extractURL(line);
                urlCounts.put(url, urlCounts.getOrDefault(url, 0) + 1);
            }
        }

        return urlCounts;
    }

    // 提取URL的辅助函数
    private static String extractURL(String logLine) {
        // 根据日志格式提取URL
        // 示例：假设日志行的格式是 "timestamp URL"
        String[] parts = logLine.split("https://", 2);
        return parts.length > 1 ? parts[1].trim() : "";
    }

    // 排序URL及其访问次数
    private static List<Map.Entry<String, Integer>> sortURLsByVisits(Map<String, Integer> urlCounts) {
        return urlCounts.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
    }
}

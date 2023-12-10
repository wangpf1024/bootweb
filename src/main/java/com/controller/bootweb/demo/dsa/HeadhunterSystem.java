package com.controller.bootweb.demo.dsa;

import java.util.*;

class Headhunter {
    String id;
    int points;

    public Headhunter(String id, int points) {
        this.id = id;
        this.points = points;
    }
}

public class HeadhunterSystem {
    private TreeMap<Integer, List<String>> pointsMap; // 通过积分建立索引
    private HashMap<String, Headhunter> headhuntersMap; // 通过ID快速查找猎头信息

    public HeadhunterSystem() {
        pointsMap = new TreeMap<>();
        headhuntersMap = new HashMap<>();
    }

    // 添加猎头信息
    public void addHeadhunter(String id, int points) {
        Headhunter headhunter = new Headhunter(id, points);

        // 更新积分Map
        pointsMap.computeIfAbsent(points, k -> new ArrayList<>()).add(id);

        // 更新猎头Map
        headhuntersMap.put(id, headhunter);
    }

    // 删除猎头信息
    public void removeHeadhunter(String id) {
        Headhunter headhunter = headhuntersMap.get(id);
        if (headhunter != null) {
            // 从积分Map中移除
            pointsMap.get(headhunter.points).remove(id);

            // 从猎头Map中移除
            headhuntersMap.remove(id);
        }
    }

    // 更新猎头积分
    public void updatePoints(String id, int newPoints) {
        removeHeadhunter(id); // 先移除再重新添加
        addHeadhunter(id, newPoints);
    }

    // 查找积分在某个区间的猎头ID列表
    public List<String> findHeadhuntersInPointsRange(int start, int end) {
        List<String> result = new ArrayList<>();

        // 使用 TreeMap 的 subMap 方法找到积分区间的子集
        NavigableMap<Integer, List<String>> subMap = pointsMap.subMap(start, true, end, true);

        // 合并子集中的所有ID
        for (List<String> ids : subMap.values()) {
            result.addAll(ids);
        }

        return result;
    }

    // 查找按照积分从小到大排名在第x位到第y位之间的猎头ID列表
    public List<String> findHeadhuntersByRank(int x, int y) {
        List<String> result = new ArrayList<>();

        // 遍历积分Map，记录排名
        int currentRank = 1;
        for (List<String> ids : pointsMap.values()) {
            for (String id : ids) {
                if (currentRank >= x && currentRank <= y) {
                    result.add(id);
                }
                currentRank++;
            }
        }

        return result;
    }

    public List<String> findHeadhuntersByRankOptimized(int x, int y) {
        List<String> result = new ArrayList<>();
        int currentRank = 1;

        for (List<String> ids : pointsMap.values()) {
            for (String id : ids) {
                if (currentRank > y) {
                    // 已经超过排名范围，结束遍历
                    return result;
                }

                if (currentRank >= x) {
                    // 在排名范围内，添加到结果列表
                    result.add(id);
                }

                currentRank++;
            }
        }

        return result;
    }


    // 根据ID查找猎头信息
    public Headhunter findHeadhunterById(String id) {
        return headhuntersMap.get(id);
    }

    // 获取所有猎头ID
    public Iterable<String> getAllHeadhunters() {
        return headhuntersMap.keySet();
    }

    // 获取所有积分信息
    public Iterable<Integer> getAllPoints() {
        return pointsMap.keySet();
    }
}

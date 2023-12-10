package com.controller.bootweb.demo.dsa;

import java.util.List;

public class TestHeadhunterSystem {
    public static void main(String[] args) {
        HeadhunterSystem headhunterSystem = new HeadhunterSystem();

        // 添加猎头信息
        headhunterSystem.addHeadhunter("hunter1", 100);
        headhunterSystem.addHeadhunter("hunter2", 150);
        headhunterSystem.addHeadhunter("hunter3", 120);
        headhunterSystem.addHeadhunter("hunter4", 180);
        headhunterSystem.addHeadhunter("hunter5", 90);

        // 打印所有猎头ID和积分
        System.out.println("All Headhunters:");
        for (String id : headhunterSystem.getAllHeadhunters()) {
            System.out.println("ID: " + id + ", Points: " + headhunterSystem.findHeadhunterById(id).points);
        }

        // 查找积分在某个区间的猎头ID列表
        int startRange = 100;
        int endRange = 150;
        List<String> headhuntersInRange = headhunterSystem.findHeadhuntersInPointsRange(startRange, endRange);
        System.out.println("\nHeadhunters in Points Range (" + startRange + " to " + endRange + "):");
        System.out.println(headhuntersInRange);

        // 查找按照积分从小到大排名在第x位到第y位之间的猎头ID列表
        int rankX = 2;
        int rankY = 4;
        List<String> headhuntersByRank = headhunterSystem.findHeadhuntersByRankOptimized(rankX, rankY);
        System.out.println("\nHeadhunters by Rank (" + rankX + " to " + rankY + "):");
        System.out.println(headhuntersByRank);
    }
}

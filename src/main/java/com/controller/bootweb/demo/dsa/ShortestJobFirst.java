package com.controller.bootweb.demo.dsa;

import java.util.Arrays;

import java.util.Arrays;

public class ShortestJobFirst {

    public static int minimizeTotalWaitTime(int[] serviceTimes) {
        if (serviceTimes == null || serviceTimes.length == 0) {
            return 0;
        }

        Arrays.sort(serviceTimes);  // 按照服务时间从小到大排序

        int totalWaitTime = 0;
        int currentWaitTime = 0;

        for (int serviceTime : serviceTimes) {
            totalWaitTime += currentWaitTime;  // 累加当前人的等待时间
            currentWaitTime += serviceTime;    // 累加当前人的服务时间
        }

        return totalWaitTime;
    }

    public static void main(String[] args) {
        int[] serviceTimes = {5, 2, 8, 4};
        int result = minimizeTotalWaitTime(serviceTimes);
        System.out.println("最小总等待时间：" + result); // 输出：最小总等待时间：19
    }
}


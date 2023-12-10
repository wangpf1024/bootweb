package com.controller.bootweb.demo.dsa;

public class CellDivision {

    public static int countCells(int hours) {
        if (hours == 0) {
            // 初始时刻，容器内有1个细胞
            return 1;
        } else {
            // 在前一个小时的基础上，每个细胞分裂成两个细胞
            return 2 * countCells(hours - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5; // 假设 n 小时
        int result = countCells(n);
        System.out.println(n + " 小时后，容器内有 " + result + " 个细胞。");
    }
}

package com.controller.bootweb.demo.dsa;

public class CellDivision2 {

    public static int countCells(int hours) {
        if (hours == 0) {
            return 1;
        }

        int[] cellCounts = new int[hours + 1];
        cellCounts[0] = 1;

        for (int i = 1; i <= hours; i++) {
            cellCounts[i] = 2 * cellCounts[i - 1];
        }

        return cellCounts[hours];
    }

    public static void main(String[] args) {
        int n = 5; // 假设 n 小时
        int result = countCells(n);
        System.out.println(n + " 小时后，容器内有 " + result + " 个细胞。");
    }
}


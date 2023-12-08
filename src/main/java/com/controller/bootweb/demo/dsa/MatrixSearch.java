package com.controller.bootweb.demo.dsa;

public class MatrixSearch {

    // 在二维矩阵中查找目标值
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0, col = cols - 1;  // 从矩阵的右上角开始搜索

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;  // 找到目标值
            } else if (matrix[row][col] < target) {
                row++;  // 当前值小于目标值，向下移动
            } else {
                col--;  // 当前值大于目标值，向左移动
            }
        }

        return false;  // 未找到目标值
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };

        int target = 5;

        boolean found = searchMatrix(matrix, target);

        if (found) {
            System.out.println("The target " + target + " is found in the matrix.");
        } else {
            System.out.println("The target " + target + " is not found in the matrix.");
        }
    }
}


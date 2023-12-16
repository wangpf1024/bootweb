package com.controller.bootweb.demo.dsa;

public class StringMatchBKRK {

    public static void main(String[] args) {
        char[][] matrix = {
                {'A', 'B', 'C', 'D', 'E'},
                {'F', 'G', 'H', 'I', 'J'},
                {'K', 'L', 'M', 'N', 'O'},
                {'P', 'Q', 'R', 'S', 'T'},
                {'U', 'V', 'W', 'X', 'Y'}
        };

        char[][] target1 = {
                {'H', 'I'},
                {'M', 'N'}
        };

        char[][] target2 = {
                {'B', 'C'},
                {'G', 'H'},
        };

        StringMatchBKRK matchBKRK = new StringMatchBKRK();

        System.out.println("BF Algorithm:");
        System.out.println("Target1 Found: " + matchBKRK.searchMatrixBF(matrix, target1));
        System.out.println("Target2 Found: " + matchBKRK.searchMatrixBF(matrix, target2));

        System.out.println("\nRK Algorithm:");
        System.out.println("Target1 Found: " + matchBKRK.searchMatrixRK(matrix, target1));
        System.out.println("Target2 Found: " + matchBKRK.searchMatrixRK(matrix, target2));
    }


    public boolean searchMatrixBF(char[][] matrix, char[][] target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int p = target.length;
        int q = target[0].length;

        for (int i = 0; i <= m - p; i++) {
            for (int j = 0; j <= n - q; j++) {
                if (match(matrix, target, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }
    private boolean match(char[][] matrix, char[][] target, int startRow, int startCol) {
        int p = target.length;
        int q = target[0].length;

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                if (matrix[startRow + i][startCol + j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean searchMatrixRK(char[][] matrix, char[][] target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int p = target.length;
        int q = target[0].length;

        long targetHash = calculateHash(target);

        for (int i = 0; i <= m - p; i++) {
            for (int j = 0; j <= n - q; j++) {
                if (calculateHash(matrix, i, j, p, q) == targetHash) {
                    if (match(matrix, target, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private long calculateHash(char[][] matrix, int startRow, int startCol, int rows, int cols) {
        long hash = 0;
        long base = 256;
        long mod = (long) 1e9 + 7;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                hash = (hash * base + matrix[startRow + i][startCol + j]) % mod;
            }
        }
        return hash;
    }

    private long calculateHash(char[][] matrix) {
        return calculateHash(matrix, 0, 0, matrix.length, matrix[0].length);
    }





}
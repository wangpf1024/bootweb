package com.controller.bootweb.demo.sort.selection;

public class TournamentSort {

    public static void tournamentSort(int[] array) {
        int n = array.length;

        // Create a tournament tree
        int[] tree = new int[2 * n - 1];
        buildTournamentTree(array, tree, n);

        // Perform the tournament to get the sorted order
        for (int i = 0; i < n; i++) {
            array[i] = getWinner(array, tree, i, n);
        }
    }

    private static void buildTournamentTree(int[] array, int[] tree, int n) {
        // Fill the leaves of the tournament tree with array elements
        for (int i = 0; i < n; i++) {
            tree[n - 1 + i] = i;
        }

        // Build the tournament tree from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            tree[i] = (array[tree[leftChild]] < array[tree[rightChild]]) ? tree[leftChild] : tree[rightChild];
        }
    }

    private static int getWinner(int[] array, int[] tree, int index, int n) {
        int winner = tree[0];

        // Update the tournament tree after removing the winner
        int i = winner - (n - 1);
        tree[i] = n; // Set to a large index to ensure it doesn't win future comparisons

        while (i > 0) {
            int parent = (i - 1) / 2;
            int sibling = (i % 2 == 0) ? i - 1 : i + 1;
            tree[parent] = (array[tree[i]] < array[tree[sibling]]) ? tree[i] : tree[sibling];
            i = parent;
        }

        return array[winner];
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("未排序数组：");
        printArray(array);

        tournamentSort(array);

        System.out.println("Tournament Sort 后的数组：");
        printArray(array);
    }
}


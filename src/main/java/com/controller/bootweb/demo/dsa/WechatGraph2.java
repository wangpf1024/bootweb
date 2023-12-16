package com.controller.bootweb.demo.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WechatGraph2 {
    private final int[][] adjacencyMatrix;
    private final int vertices;

    public WechatGraph2(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int v1, int v2) {
        // Add edge v1 -> v2
        adjacencyMatrix[v1][v2] = 1;
        // Add edge v2 -> v1 (for undirected graph)
        adjacencyMatrix[v2][v1] = 1;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public static void main(String[] args) {
        int numberOfVertices = 4;
        WechatGraph2 graph = new WechatGraph2(numberOfVertices);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        // Example: Get adjacency matrix
        int[][] matrix = graph.getAdjacencyMatrix();
        System.out.println("Adjacency Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
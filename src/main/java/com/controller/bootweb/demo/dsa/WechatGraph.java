package com.controller.bootweb.demo.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WechatGraph {
    private final Map<Integer, List<Integer>> adjacencyList;

    public WechatGraph() {
        this.adjacencyList = new ConcurrentHashMap<>();
    }

    public void addEdge(int v1, int v2) {
        // Add edge v1 -> v2
        adjacencyList.computeIfAbsent(v1, k -> new ArrayList<>()).add(v2);
        // Add edge v2 -> v1 (for undirected graph)
        adjacencyList.computeIfAbsent(v2, k -> new ArrayList<>()).add(v1);
    }

    public List<Integer> getNeighbors(int vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    public static void main(String[] args) {
        WechatGraph graph = new WechatGraph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        // Example: Get neighbors of vertex 1
        List<Integer> neighbors = graph.getNeighbors(1);
        System.out.println("Neighbors of vertex 1: " + neighbors);
    }
}

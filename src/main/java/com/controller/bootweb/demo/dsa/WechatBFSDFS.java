package com.controller.bootweb.demo.dsa;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class WechatBFSDFS {

    private final Map<Integer, List<Integer>> adjacencyList;

    public WechatBFSDFS() {
        this.adjacencyList = new ConcurrentHashMap<>();
    }

    public void addEdge(int v1, int v2) {
        adjacencyList.computeIfAbsent(v1, k -> new ArrayList<>()).add(v2);
        adjacencyList.computeIfAbsent(v2, k -> new ArrayList<>()).add(v1);
    }

    public List<Integer> getFriendsOfFriendsDFS(int start, int depth) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[adjacencyList.size()];

        dfs(start, depth, 0, visited, result);

        return result;
    }

    private void dfs(int current, int targetDepth, int currentDepth, boolean[] visited, List<Integer> result) {
        if (current < 0 || current >= visited.length || visited[current] || currentDepth > targetDepth) {
            return;  // Check for array index out of bounds or already visited
        }
        visited[current] = true;
        if (currentDepth <= targetDepth) {
            for (int neighbor : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                dfs(neighbor, targetDepth, currentDepth + 1, visited, result);
            }
        }
        // Move the addition of the current node to the end
        result.add(current);
        visited[current] = false;  // Backtrack
    }


    public List<Integer> getFriendsOfFriendsBFS(int start, int depth) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int currentDepth = 0;

        while (!queue.isEmpty() && currentDepth < depth) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int current = queue.poll();
                for (int neighbor : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
                if(currentDepth < depth){
                    result.add(current);
                }
            }
            currentDepth++;
        }

        return result;
    }


    public static void main(String[] args) {
        WechatBFSDFS graph = new WechatBFSDFS();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);

        int startNode = 1;
        int depth = 3;

        List<Integer> friendsOfFriendsDFS = graph.getFriendsOfFriendsDFS(startNode, depth);
        System.out.println("Friends of friends (DFS) within " + depth + " degrees of separation from node " + startNode + ": " + friendsOfFriendsDFS);

        List<Integer> friendsOfFriendsBFS = graph.getFriendsOfFriendsBFS(startNode, depth);
        System.out.println("Friends of friends (BFS) within " + depth + " degrees of separation from node " + startNode + ": " + friendsOfFriendsBFS);
    }
}

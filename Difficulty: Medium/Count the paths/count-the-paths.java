import java.util.*;

class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        // Step 2: Initialize memoization array
        Integer[] memo = new Integer[V];

        // Step 3: Call DFS with memoization
        return dfs(graph, src, dest, memo);
    }

    private int dfs(List<List<Integer>> graph, int current, int dest, Integer[] memo) {
        if (current == dest) return 1;

        // If already computed, return cached value
        if (memo[current] != null) return memo[current];

        int totalPaths = 0;
        for (int neighbor : graph.get(current)) {
            totalPaths += dfs(graph, neighbor, dest, memo);
        }

        // Cache result
        memo[current] = totalPaths;
        return totalPaths;
    }
}
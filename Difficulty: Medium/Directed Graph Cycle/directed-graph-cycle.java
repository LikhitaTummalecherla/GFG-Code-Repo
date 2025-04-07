//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[V];
        boolean[] inStack = new boolean[V];

        for (int node = 0; node < V; node++) {
            if (!visited[node]) {
                if (dfs(node, adj, visited, inStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] inStack) {
        if (inStack[node]) {
            return true;
        }
        if (visited[node]) {
            return false;
        }

        visited[node] = true;
        inStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (dfs(neighbor, adj, visited, inStack)) {
                return true;
            }
        }

        inStack[node] = false;
        return false;
    }
}
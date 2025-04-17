class Solution:
    def findMinCycle(self, V, edges):
        INF = float('inf')
        dist = [[INF] * V for _ in range(V)]
        weight = [[INF] * V for _ in range(V)]
        for i in range(V):
            dist[i][i] = 0
            weight[i][i] = 0
        for u, v, w in edges:
            dist[u][v] = w
            dist[v][u] = w
            weight[u][v] = w
            weight[v][u] = w
        ans = INF
        for k in range(V):
            for i in range(k):
                for j in range(i + 1, k):
                    if dist[i][j] != INF and weight[i][k] != INF and weight[j][k] != INF:
                        cycle_len = dist[i][j] + weight[i][k] + weight[j][k]
                        ans = min(ans, cycle_len)
            for i in range(V):
                for j in range(V):
                    if dist[i][k] != INF and dist[k][j] != INF:
                        dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
        return -1 if ans == INF else ans
        

        



#{ 
 # Driver Code Starts
# Initial Template for Python 3
import sys
import heapq

# Position this line where user code will be pasted.


def main():
    t = int(input())
    for _ in range(t):
        V = int(input())
        E = int(input())
        edges = []
        for _ in range(E):
            u, v, w = map(int, input().split())
            edges.append([u, v, w])
            edges.append([v, u, w])  # Since the graph is undirected

        obj = Solution()
        res = obj.findMinCycle(V, edges)

        print(res)


if __name__ == "__main__":
    main()

# } Driver Code Ends
/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

import java.util.*;

class Solution {
    void solve(Node root, List<Integer> ans) {
        if (root == null) return;
        solve(root.left, ans);
        ans.add(root.data);
        solve(root.right, ans);
    }

    ArrayList<Integer> getKClosest(Node root, int target, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve(root, ans);
        Collections.sort(ans);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int x : ans) {
            if (q.size() < k) q.offer(x);
            else {
                int t = q.peek();
                if (Math.abs(t - target) > Math.abs(x - target)) {
                    q.poll();
                    q.offer(x);
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) res.add(q.poll());
        return res;
    }
}
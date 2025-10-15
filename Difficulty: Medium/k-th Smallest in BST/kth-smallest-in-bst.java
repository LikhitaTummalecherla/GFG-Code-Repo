/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    private int kSmallest(Node root, int[] k) {
        if (root == null) return -1;

        int left = kSmallest(root.left, k);
        if (left != -1) return left;

        if (k[0] == 1) return root.data;
        k[0]--;

        return kSmallest(root.right, k);
    }

    public int kthSmallest(Node root, int k) {
        return kSmallest(root, new int[]{k});
    }
}
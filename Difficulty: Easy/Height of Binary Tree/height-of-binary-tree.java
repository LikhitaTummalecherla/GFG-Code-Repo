/*
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int height(Node root) {
        // Base case: if the tree is empty
        if (root == null)
            return -1; // height in terms of edges, not nodes
        
        // Recursively calculate the height of left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        // Height of current node = 1 + max of left and right subtree heights
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

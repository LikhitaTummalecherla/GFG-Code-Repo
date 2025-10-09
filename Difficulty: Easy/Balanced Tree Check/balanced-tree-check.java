/*
class Node {
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public boolean isBalanced(Node root) {
        // If checkHeight returns -1, it means the tree is not balanced
        return checkHeight(root) != -1;
    }

    // Helper method to check balance and return height
    private int checkHeight(Node root) {
        // Base case
        if (root == null)
            return 0;
        
        // Recursively get height of left subtree
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) // if left subtree is unbalanced
            return -1;
        
        // Recursively get height of right subtree
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) // if right subtree is unbalanced
            return -1;
        
        // If difference between heights > 1 → not balanced
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        
        // Return height of current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

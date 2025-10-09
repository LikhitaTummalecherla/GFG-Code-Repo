/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper function with min and max constraints
    private boolean checkBST(Node root, long min, long max) {
        if (root == null)
            return true; // empty tree is BST

        // Node value must be within min and max
        if (root.data <= min || root.data >= max)
            return false;

        // Recursively check left and right subtrees with updated constraints
        return checkBST(root.left, min, root.data) &&
               checkBST(root.right, root.data, max);
    }
}

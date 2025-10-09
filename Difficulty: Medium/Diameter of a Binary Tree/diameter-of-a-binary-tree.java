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
} */

class Solution {
    int maxDiameter = 0; // to keep track of the maximum diameter
    
    public int diameter(Node root) {
        // Call helper function to calculate height and update diameter
        height(root);
        return maxDiameter;
    }
    
    // Helper function to calculate height
    private int height(Node root) {
        if (root == null)
            return 0;
        
        // Recursively find the height of left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        // Update the diameter (edges = leftHeight + rightHeight)
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        
        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

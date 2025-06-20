/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    public boolean isDeadEnd(Node root) {
        return checkDeadEnd(root, 1, Integer.MAX_VALUE);
    }

    // Helper function to recursively check dead ends
    private boolean checkDeadEnd(Node node, int min, int max) {
        if (node == null) return false;

        // Dead end condition: no room to insert further numbers
        if (min == max) return true;

        // Recur for left and right subtrees
        return checkDeadEnd(node.left, min, node.data - 1) ||
               checkDeadEnd(node.right, node.data + 1, max);
    }
}
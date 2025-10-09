/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSumProperty(Node root) {
        // Base case: empty tree
        if (root == null)
            return true;

        // If leaf node, automatically satisfies property
        if (root.left == null && root.right == null)
            return true;

        // Get left and right child values (0 if null)
        int leftVal = (root.left != null) ? root.left.data : 0;
        int rightVal = (root.right != null) ? root.right.data : 0;

        // Check current node and recursively check left and right subtrees
        return (root.data == leftVal + rightVal)
                && isSumProperty(root.left)
                && isSumProperty(root.right);
    }
}

/*
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    void mirror(Node root) {
        // Base case: if tree is empty
        if (root == null)
            return;

        // Recursively call for left and right subtrees
        mirror(root.left);
        mirror(root.right);

        // Swap the left and right children
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}


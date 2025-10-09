/*
class Node{
    int data;
    Node left, right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    public boolean isIdentical(Node r1, Node r2) {
        // If both trees are empty
        if (r1 == null && r2 == null)
            return true;
        
        // If one tree is empty and the other is not
        if (r1 == null || r2 == null)
            return false;
        
        // Check if current nodes are equal 
        // and recursively check left and right subtrees
        return (r1.data == r2.data)
                && isIdentical(r1.left, r2.left)
                && isIdentical(r1.right, r2.right);
    }
}

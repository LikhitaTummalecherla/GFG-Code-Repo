/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/
class Solution {
    public Node segregate(Node head) {
        // code here
        int []arr = new int[3];
        Arrays.fill(arr, 0);
        Node curr = head;
       
        while(curr != null){
            if(curr.data == 0) arr[0] += 1;
            else if(curr.data == 1) arr[1] += 1;
            else arr[2] += 1;
           
            curr = curr.next;
        }
       
        curr = head;
        int num = arr[0];
        while(num-- > 0) {
            curr.data = 0; curr = curr.next;
        }
        num = arr[1];
        while(num-- > 0) {
            curr.data = 1; curr = curr.next;
        }
        num = arr[2];
        while(num-- > 0) {
            curr.data = 2; curr = curr.next;
        }
        return head;
    }
}
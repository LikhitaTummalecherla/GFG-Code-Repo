import java.util.Stack;

class Solution {
    public int findLength(int[] color, int[] radius) {
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < color.length; i++) {
            if (!stack.isEmpty() && stack.peek()[0] == color[i] && stack.peek()[1] == radius[i]) {
                
                stack.pop();
            } else {
                
                stack.push(new int[]{color[i], radius[i]});
            }
        }

        return stack.size();
    }
}
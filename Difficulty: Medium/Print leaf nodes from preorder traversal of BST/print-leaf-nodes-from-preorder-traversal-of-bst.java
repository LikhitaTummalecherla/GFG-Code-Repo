import java.util.*;

class Solution {
    int index;

    public ArrayList<Integer> leafNodes(int[] preorder) {
        index = 0;
        ArrayList<Integer> result = new ArrayList<>();
        findLeaves(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, result);
        return result;
    }

    private void findLeaves(int[] preorder, int lower, int upper, ArrayList<Integer> result) {
        if (index >= preorder.length) return;

        int val = preorder[index];
        if (val < lower || val > upper) return;

        index++;
        int currIndex = index;

        findLeaves(preorder, lower, val, result);
        findLeaves(preorder, val, upper, result);

        if (index == currIndex) {
            result.add(val);
        }
    }
}
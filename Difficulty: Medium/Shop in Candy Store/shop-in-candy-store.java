import java.util.*;

class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        Arrays.sort(prices);
        int n = prices.length;

        int minCost = 0;
        int maxCost = 0;

        // Minimum cost
        int i = 0, j = n - 1;
        while (i <= j) {
            minCost += prices[i];
            i++;
            j -= k; // take k from the end for free
        }

        // Maximum cost
        i = 0; 
        j = n - 1;
        while (i <= j) {
            maxCost += prices[j];
            j--;
            i += k; // take k from the start for free
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(minCost);
        ans.add(maxCost);
        return ans;
    }
}
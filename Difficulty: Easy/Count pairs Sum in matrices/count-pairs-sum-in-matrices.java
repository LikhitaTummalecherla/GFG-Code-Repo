import java.util.*;

class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        int n = mat1.length;
        Map<Integer, Integer> freq = new HashMap<>();

        // Build frequency map for mat2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = mat2[i][j];
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }

        int count = 0;

        // Traverse mat1 and count complements from mat2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = mat1[i][j];
                int b = x - a;
                count += freq.getOrDefault(b, 0);
            }
        }

        return count;
    }
}
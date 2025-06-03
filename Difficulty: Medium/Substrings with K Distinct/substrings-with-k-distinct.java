// User function Template for Java

// User function Template for Java

class Solution {
    int countSubstr(String s, int k) {
        return countAtMostKDistinct(s, k) - countAtMostKDistinct(s, k - 1);
    }

    private int countAtMostKDistinct(String s, int k) {
        int[] freq = new int[26]; // Only lowercase letters
        int left = 0, count = 0, distinct = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (freq[ch - 'a'] == 0) {
                distinct++;
            }
            freq[ch - 'a']++;

            while (distinct > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                if (freq[leftChar - 'a'] == 0) {
                    distinct--;
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}
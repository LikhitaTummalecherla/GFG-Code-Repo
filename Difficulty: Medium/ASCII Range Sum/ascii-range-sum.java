class Solution {
    public ArrayList<Integer> asciirange(String s) {
        int n = s.length();
        
        ArrayList<Integer> ans = new ArrayList<>();
        int[][] pair = new int[26][2];
        int[] prefix = new int[n + 1];
       
        
        for(int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
             
            prefix[i + 1] = ch + prefix[i]; 
            int index = ch - 'a';
            
            if(pair[index][0] > 0) 
                pair[index][1] = i + 1;
            
            else pair[index][0] = i + 1;
        }
        
        for(int i = 0; i < 26; ++i) {
            int left = pair[i][0];
            int right = pair[i][1];
            
            if(right > 0) {
                int res = prefix[right - 1] - prefix[left];
                if(res > 0) ans.add(res);
            }
        }
        
        return ans;
    }
}
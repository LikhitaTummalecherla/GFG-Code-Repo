// User function Template for Java

class Solution {
    public int getSingle(int[] nums) {
        int sing=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            sing=sing^nums[i];
           
        }
         return sing;
    }
}
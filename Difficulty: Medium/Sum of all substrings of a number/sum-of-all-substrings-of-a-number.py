class Solution:
    def sumSubstrings(self,s):
        left=0
        
        sum1=0
        right=0
        while left<len(s)-1:
            #print(s[left:right+1])
            sum1+=int(s[left:right+1])
            
            right+=1
            if right==len(s):
                left+=1
                right=left
        return (sum1+int(s[-1]))
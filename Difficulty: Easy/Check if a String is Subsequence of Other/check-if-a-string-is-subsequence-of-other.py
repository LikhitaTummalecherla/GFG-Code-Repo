class Solution:
    def isSubSeq(self, s1, s2):
        # code here
        m = len(s1)
        n = len(s2)
        i = j = 0
        
        while i < m and j < n:
            if s1[i] == s2[j]:
                i+=1
            j+=1
        return i == m
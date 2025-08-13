from math import ceil
class Solution:
    def minSoldiers(self, arr, k):
        n=len(arr)
        needed=ceil(n/2)
        notLucky=[]
        lucky=res=0
        for i in arr:
            if lucky<needed:
                if i%k==0:
                    lucky+=1
                else:
                    notLucky.append(k-(i%k))
            else:
                return res
        notLucky.sort(reverse=True)
        while lucky<needed:
            res+=notLucky.pop()
            lucky+=1
        return res
#User function Template for python3
class Solution:
    def missingNumber(self, arr):
        # code here
        arr.sort()
        k=1
        for i in range(len(arr)):
            flag=False
            if arr[i]==k:
                flag=True
            if not flag:
                return k
            k+=1
        return k
        


#{ 
 # Driver Code Starts
#Initial Template for Python 3

t = int(input())
for _ in range(0, t):
    arr = list(map(int, input().split()))
    s = Solution().missingNumber(arr)
    print(s)

    print("~")
# } Driver Code Ends
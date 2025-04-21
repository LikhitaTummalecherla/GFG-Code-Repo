class Solution:
    def missingNum(self, arr):
        n = len(arr) + 1  
        total = n * (n + 1) // 2
        actual_sum = sum(arr)
        return total - actual_sum

#{ 
 # Driver Code Starts
#Initial Template for Python 3

t = int(input())
for _ in range(0, t):
    arr = list(map(int, input().split()))
    s = Solution().missingNum(arr)
    print(s)

    print("~")
# } Driver Code Ends
#User function Template for python3

class Solution:
    def nCr(self, n, r):
        # code here
        if r > n:
            return 0
            
        if r == 0 or r == n:
            return 1
            
        r = min(r, n-r)
        
        result = 1
        
        for i in range(r):
            result *= (n-i)
            result //= (i+1)
            
        return result
#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n = int(input())
        r = int(input())
        ob = Solution()
        print(ob.nCr(n, r))
        print("~")
# } Driver Code Ends
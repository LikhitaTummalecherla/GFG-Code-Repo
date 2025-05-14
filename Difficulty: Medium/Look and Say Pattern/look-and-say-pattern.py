class Solution:
    def countAndSay(self, n):
        if n == 1:
            return "1"
        
        prev = "1"
        
        for _ in range(2, n + 1):
            curr = ""
            count = 1
            for i in range(1, len(prev)):
                if prev[i] == prev[i - 1]:
                    count += 1
                else:
                    curr += str(count) + prev[i - 1]
                    count = 1
            curr += str(count) + prev[-1]
            prev = curr
        
        return prev


#{ 
 # Driver Code Starts
#Initial Template for Python 3
if __name__ == '__main__':

    t = int(input())

    for _ in range(t):
        n = int(input())

        solObj = Solution()

        print(solObj.countAndSay(n))

        print("~")
# } Driver Code Ends
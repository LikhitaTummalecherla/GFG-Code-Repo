#{ 
 # Driver Code Starts

# } Driver Code Ends

#User function Template for python3
class Solution:
    def findTarget(self, arr, target):
        low, high = 0, len(arr) - 1

        while low <= high:
            mid = (low + high) // 2

            #
            if arr[mid] == target:
                return mid
            if mid > low and arr[mid - 1] == target:
                return mid - 1
            if mid < high and arr[mid + 1] == target:
                return mid + 1

           
            if target < arr[mid]:
                high = mid - 2
            else:
                low = mid + 2

        return -1  


#{ 
 # Driver Code Starts.

if __name__ == "__main__":
    t = int(input())  # Number of test cases

    for _ in range(t):
        arr = list(map(int, input().strip().split()))  # Read the array
        target = int(input().strip())  # Read the target

        sln = Solution()
        ans = sln.findTarget(arr, target)
        print(ans)
        print("~")
# } Driver Code Ends
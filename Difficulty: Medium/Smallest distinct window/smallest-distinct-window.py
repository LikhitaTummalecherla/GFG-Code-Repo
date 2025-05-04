#User function Template for python3

class Solution:
    def findSubString(self, s):
        n = len(s)
        if n == 0:
            return 0

        unique_chars = set(s)
        required = len(unique_chars)

        count_map = {}
        min_len = n + 1
        left = 0
        formed = 0

        for right in range(n):
            char = s[right]
            count_map[char] = count_map.get(char, 0) + 1

            if count_map[char] == 1:
                formed += 1

            while formed == required:
                min_len = min(min_len, right - left + 1)

                count_map[s[left]] -= 1
                if count_map[s[left]] == 0:
                    formed -= 1
                left += 1

        return min_len
    
    


#{ 
 # Driver Code Starts
#Initial Template for Python 3


def main():
    T = int(input())
    while (T > 0):
        str = input()
        ob = Solution()
        print(ob.findSubString(str))

        T -= 1
        print("~")


if __name__ == "__main__":
    main()

# } Driver Code Ends
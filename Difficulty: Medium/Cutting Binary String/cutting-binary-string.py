class Solution:
    def cuts(self, s):
        n = len(s)
        dp = [float('inf')] * (n + 1)
        dp[0] = 0
        
        def is_power_of_five(binary_str):
            if binary_str[0] == '0':
                return False
            num = int(binary_str, 2)
            while num > 1:
                if num % 5 != 0:
                    return False
                num //= 5
            return num == 1
        
        for i in range(1, n + 1):
            for j in range(i):
                if is_power_of_five(s[j:i]):
                    dp[i] = min(dp[i], dp[j] + 1)
        
        return dp[n] if dp[n] != float('inf') else -1
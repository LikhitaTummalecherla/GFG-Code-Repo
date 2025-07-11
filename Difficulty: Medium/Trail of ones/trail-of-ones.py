class Solution:
    def countConsec(self, n: int) -> int:
        if n == 1:
            return 0  # only "0", "1" → no consecutive 1s possible

        dp = [0] * (n + 1)
        dp[1] = 2  # "0", "1"
        dp[2] = 3  # "00", "01", "10"

        for i in range(3, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2]

        total = 2 ** n
        return total - dp[n]
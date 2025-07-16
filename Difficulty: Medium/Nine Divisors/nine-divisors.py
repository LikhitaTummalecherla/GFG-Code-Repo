class Solution:
    def countNumbers(self, n):
        import math
        
        # Step 1: Sieve of Eratosthenes
        limit = int(math.sqrt(n)) + 1
        is_prime = [True] * (limit + 1)
        is_prime[0] = is_prime[1] = False
        for i in range(2, int(math.sqrt(limit)) + 1):
            if is_prime[i]:
                for j in range(i * i, limit + 1, i):
                    is_prime[j] = False
        primes = [i for i, val in enumerate(is_prime) if val]

        count = 0
        
        # Step 2: Count numbers of the form p^8
        for p in primes:
            if p ** 8 <= n:
                count += 1
            else:
                break

        # Step 3: Count numbers of the form p^2 * q^2
        length = len(primes)
        for i in range(length):
            for j in range(i + 1, length):
                num = (primes[i] ** 2) * (primes[j] ** 2)
                if num <= n:
                    count += 1
                else:
                    break
        
        return count
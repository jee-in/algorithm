import sys
import math
input = sys.stdin.readline

def get_prime_list(n):
  is_prime = [1 for _ in range(n + 1)]
  is_prime[0] = 0
  is_prime[1] = 0
  for i in range(2, math.floor(math.sqrt(n)) + 1):
    for j in range(i + 1, n + 1):
      if (j % i == 0): is_prime[j] = 0
  return is_prime

is_prime = get_prime_list(1000)
n = int(input().strip())
nums = list(map(int, input().split()))
print(sum(is_prime[num] for num in nums))
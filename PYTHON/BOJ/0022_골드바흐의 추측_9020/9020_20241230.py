import sys
import math
input = sys.stdin.readline

def get_is_prime_list(N):
  is_prime = [1] * (N + 1)
  is_prime[0] = 0
  is_prime[1] = 0
  is_prime[2] = 1

  for i in range(2, math.floor(math.sqrt(N)) + 1):
    for j in range(i + 1, N + 1):
      if (j % i == 0): is_prime[j] = 0
  return is_prime

is_prime = get_is_prime_list(10000)
n = int(input().strip())
for _ in range(n):
  num = int(input().strip())
  elems = ()
  for i in range(1, int(num/2) + 1):
    if is_prime[i] == 1 and is_prime[num - i] == 1:
      elems = (i, num - i)
  print(*elems)

import sys
import math
input = sys.stdin.readline

def is_prime(num):
  if num == 0: return False
  if num == 1: return False
  if num == 2: return True

  for i in range(2, math.floor(math.sqrt(num)) + 1):
    if (num % i == 0): return False
  return True

N = int(input().strip())
for _ in range(N):
  num = int(input().strip())
  half = num // 2

  for i in range(half, -1, -1):
    if is_prime(i) and is_prime(num - i):
      print(i, num - i)
      break
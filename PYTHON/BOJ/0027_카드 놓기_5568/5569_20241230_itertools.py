import sys
from itertools import permutations
input = sys.stdin.readline

n = int(input().strip())
k = int(input().strip())
cards = list(input().strip() for _ in range(n))

combination = set()
per = permutations(cards, k)
for p in per:
  temp = ''.join(list(p))
  combination.add(temp)

print(len(combination))
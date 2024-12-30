import sys
input = sys.stdin.readline

def solve(a, b, c):
  if b == 1:
    return a % c
  
  half = solve(a, b // 2, c)
  if b % 2 == 0:
    return (half * half) % c
  else:
    return (half * half * a) % c

a, b, c = map(int, input().split())
print(solve(a, b, c))

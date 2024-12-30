import sys
input = sys.stdin.readline

def get_score(answer):
  stack = []
  total_score = 0
  for a in answer:
    if a == 'O':
      stack.append('O')
      total_score += len(stack)
    else:
      stack = []
  
  return total_score

n = int(input().strip())
for _ in range(n):
  print(get_score(input().strip()))
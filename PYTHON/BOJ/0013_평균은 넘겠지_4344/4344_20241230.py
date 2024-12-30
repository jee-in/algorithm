import sys
input = sys.stdin.readline

def get_average(scores):
  return sum(scores) / len(scores)

def get_top(scores, average):
  top = 0
  for i in range(len(scores)):
    if scores[i] > average: top += 1
  return top

n = int(input().strip())  
for _ in range(n):
  line = input().split()
  students = int(line[0])
  scores = list(map(int, line[1:]))
  top = get_top(scores, get_average(scores))
  
  print(f"{top/students*100:.3f}%")
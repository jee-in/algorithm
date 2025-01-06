import sys
input = sys.stdin.readline

def find_closest_to_zero(liquids):
  liquids.sort(key = abs)

  diff = []
  for i in range(1, len(liquids)):
    temp_abs = abs(liquids[i] + liquids[i - 1])
    diff.append((temp_abs, (i, i - 1)))
  
  diff.sort(key = lambda x: x[0])
  indexes = diff[0][1]

  return sorted((liquids[indexes[0]], liquids[indexes[1]]))

if __name__ == '__main__':
  N = int(input().strip())
  liquids = list(map(int, input().split()))

  result = find_closest_to_zero(liquids)
  print(*result)
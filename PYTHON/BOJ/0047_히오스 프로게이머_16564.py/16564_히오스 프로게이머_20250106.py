import sys
input = sys.stdin.readline

def get_gaps(levels):
  return [levels[i] - levels[i - 1] for i in range(1, len(levels))]

def get_upgrade_levels(levels, K):
  gaps = get_gaps(levels)

  if len(levels) == 0: return K

  upgrade_level = 0
  for i in range(len(gaps)):
    required = gaps[i] * (i + 1)

    if K >= required:
      K -= required
      upgrade_level += gaps[i]
    else:
      upgrade_level += (K // (i + 1))
      return upgrade_level
  
  upgrade_level += (K // len(levels))
  return upgrade_level

def find_max_level(levels, K):
  levels.sort()
  return levels[0] + get_upgrade_levels(levels, K)

if __name__ == '__main__':
  N, K = map(int, input().split())
  levels = [int(input().strip()) for _ in range(N)]

  result = find_max_level(levels, K)
  print(result)
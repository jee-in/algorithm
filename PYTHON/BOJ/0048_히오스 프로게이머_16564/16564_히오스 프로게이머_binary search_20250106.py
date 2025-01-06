import sys
input = sys.stdin.readline

def find_max_level(levels, K):
  result = 0
  left = min(levels)
  right = left + K

  while left <= right:
    mid = (left + right) // 2
    sum_upgrade = sum(mid - levels[i] for i in range(len(levels)) if mid > levels[i])

    if sum_upgrade == K:
      return mid
    elif sum_upgrade < K:
      result = mid
      left = mid + 1
    else:
      right = mid - 1
  return result

if __name__ == '__main__':
  N, K = map(int, input().split())
  levels = [int(input()) for _ in range(N)]

  result = find_max_level(levels, K)
  print(result)
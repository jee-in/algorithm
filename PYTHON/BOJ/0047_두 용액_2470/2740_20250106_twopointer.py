import sys
input = sys.stdin.readline

def find_closest_to_zero(liquids):
  liquids.sort()

  # 최적화 코드
  if liquids[0] >= 0: return (liquids[0], liquids[1])
  if liquids[-1] <= 0: return (liquids[-2], liquids[-1])

  # 투 포인터 탐색
  left = 0
  right = len(liquids) - 1

  closest_sum = float('inf')
  result = (liquids[0], liquids[-1])
  while left < right:
    temp_sum = liquids[right] + liquids[left]

    if abs(temp_sum) < abs(closest_sum):
      closest_sum = temp_sum
      result = (liquids[left], liquids[right])
    
    if temp_sum == 0:
      return result
    elif temp_sum < 0:
      left += 1
    else:
      right -= 1
  
  return result

if __name__ == '__main__':
  N = int(input().strip())
  liquids = list(map(int, input().split()))

  result = find_closest_to_zero(liquids)
  print(*result)
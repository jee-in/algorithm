import sys
input = sys.stdin.readline

def get_first_non_negative(nums):
  for i in range(len(nums)):
    if nums[i] >= 0:
      return i
    
def find_combination(negatives, non_negatives):
  min_abs = float('inf')
  combination = None

  # 음수끼리의 합
  if (len(negatives) >= 2): 
    neg_sum = negatives[-2] + negatives[-1]
    min_abs = min(abs(neg_sum), min_abs)
    combination = (negatives[-2], negatives[-1])

  # 양수(0 포함)끼리의 합
  if (len(non_negatives) >= 2):
    non_neg_sum = non_negatives[1] - non_negatives[0]
    min_abs = min(abs(non_neg_sum), min_abs)
    combination = (non_negatives[0], non_negatives[1])

  # 음수와 양수의 합
  for i in range(len(negatives)):
    neg = negatives[i]
    for j in range(len(non_negatives)):
      non_neg = non_negatives[j]
      if abs(neg + non_neg) < min_abs:
        mix_sum = neg + non_neg
        min_abs = min(abs(mix_sum), min_abs)
        combination = (neg, non_neg)

  return combination

def find_closest_to_zero(liquids):
  if liquids[0] >= 0:
    return liquids[0] + liquids[1]
  
  if liquids[-1] <= 0:
    return liquids[-1] + liquids[-2]

  first_non_negative = get_first_non_negative(liquids)
  negatives = sorted(liquids[:first_non_negative])
  non_negatives = sorted(liquids[first_non_negative:])

  combination = find_combination(negatives, non_negatives)
  return combination

if __name__ == '__main__':
  N = int(input().strip())
  liquids = sorted(map(int, input().split()))

  print(*find_closest_to_zero(liquids))
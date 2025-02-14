import sys
input = sys.stdin.readline

dp = {0: 3}
def get_length(k):
  if k in dp: return dp[k]
  dp[k] = (2 * get_length(k - 1) + (k + 3))
  return dp[k]

def get_depth(length):
  k = 0
  while length > get_length(k):
    k += 1
  return k

def get_char(depth, N):
  if depth == 0:
    return "m" if N == 1 else "o"

  prev = get_length(depth - 1)

  if N <= prev:
    return get_char(depth - 1, N)
  elif N <= prev + (depth + 3):
    return "m" if N - prev == 1 else "o"
  else:
    return get_char(depth - 1, N - (prev + (depth + 3)))

if __name__ == "__main__":
  N = int(input().strip())
  depth = get_depth(N)
  answer = get_char(depth, N)
  print(answer)
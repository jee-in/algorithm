import sys
input = sys.stdin.readline

def get_length(k):
  if k == 0:
    return 3
  return (2 * get_length(k - 1) + (k + 3))

def get_depth(length):
  k = 0
  while length > get_length(k):
    k += 1
  return k

def get_char(depth, N):
  if depth == 0:
    return "m" if N == 1 else "o"

  prev = get_length(depth - 1)

  if N < prev + 1:
    return get_char(depth - 1, N)
  elif prev <= N <= prev + (depth + 3):
    N -= prev
    return "m" if N == 1 else "o"
  elif prev + (depth + 3) < N:
    N -= (prev + (depth + 3))
    return get_char(depth - 1, N)

if __name__ == "__main__":
  N = int(input().strip())
  depth = get_depth(N)
  answer = get_char(depth, N)
  print(answer)
from collections import deque

arr = [1, 2, 3, 4, 5, 6]
r = 2

def combination(arr, r, start, temp):
  if r == 0:
    result.append(list(temp))
    return

  for i in range(start, len(arr)):
    temp.append(arr[i])
    combination(arr, r - 1, i + 1, temp)
    temp.pop()

result = []
combination(arr, r, 0, deque())
print(result)
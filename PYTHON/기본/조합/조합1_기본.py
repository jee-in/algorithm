arr = [1, 2, 3, 4, 5, 6]
r = 2

def combination(arr, r, start, temp):
  if r == 0:
    result.append(temp)
    return

  for i in range(start, len(arr)):
    combination(arr, r - 1, i + 1, temp + [arr[i]])

result = []
combination(arr, r, 0, [])
print(result)
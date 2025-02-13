arr = [1, 2, 3, 4, 5, 6]
r = 2

def combination(arr, r, start, temp):
  if r == 0:
    # result.append(temp) # 이때의 temp는 최종 temp의 값을 가리킴
    result.append(temp[:])
    return

  for i in range(start, len(arr)):
    temp.append(arr[i])
    combination(arr, r - 1, i + 1, temp)
    temp.pop()

result = []
combination(arr, r, 0, [])
print(result)
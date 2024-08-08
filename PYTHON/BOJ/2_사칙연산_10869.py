
######## 기억할 내용 ########

# A / B
# - 실제로 A를 B로 나눈 값 <예시> 7 / 3 -> 2.333333333....

# A // B 의 결과
# - A를 B로 나는 몫 <예시> 7 / 3 -> 2

# Case 1) input() 사용, print() 다섯 번 사용
nums = input().split(" ")
A = int(nums[0])
B = int(nums[1])

print(A + B)
print(A - B)
print(A * B)
print(A // B) 
print(A % B)

# Case 2) input() 사용, print() 다섯 번 사용하는 대신 "\n" 사용
# nums = input().split(" ")
# A = int(nums[0])
# B = int(nums[1])

# print(A + B, '\n', A - B, '\n', A * B, '\n', A // B, '\n', A % B, sep='')

# Case 3) sys.stdin.readline() 사용, print() 다섯 번 사용
# import sys
# nums = list(map(int, sys.stdin.readline().split()))
# A = nums[0]
# B = nums[1]

# print(A + B)
# print(A - B)
# print(A * B)
# print(A // B) 
# print(A % B)

# Case 4) sys.stdin.readline() 사용, print() 다섯 번 사용하는 대신 "\n" 사용
# import sys
# nums = list(map(int, sys.stdin.readline().split()))
# A = nums[0]
# B = nums[1]

# print(A + B, '\n', A - B, '\n', A * B, '\n', A // B, '\n', A % B, sep='')
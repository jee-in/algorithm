import sys

# 두 줄에 있는 숫자 입력받는 방법
# Case1) readlines()하고 split()
# Case2) readline()을 두 번 쓰기
# Case3) input()을 쓰기

# 한 줄에 있는 숫자를 백의 자리, 십의 자리, 일의 자리로 나누는 방법
# Case1) 문자열의 index 기능 사용하기
# num1 = int(sys.stdin.readline().strip())    # strip()을 사용하여 공백 문자(공백, 탭, 개행 문자 등)을 제거
# num2 = sys.stdin.readline().strip()
# # test = list(map(int, num2))

# Case2) 숫자 배열로 변환하는 방법
# one_digit = int(num2[0])
# tenth_digit = int(num2[1])
# hundredth_digit = int(num2[2])

# Case3) 입력받자마자 숫자형으로 변환하는 방법
num1 = int(input())
num2 = int(input())

hundredth_digit = num2 // 100
tenth_digit = (num2 % 100) // 10
one_digit = (num2 % 10)

result1 = num1 * one_digit
result2 = num1 * tenth_digit
result3 = num1 * hundredth_digit

final_result = result1 + 10 * result2 + 100 * result3

print(result1)
print(result2)
print(result3)
print(final_result)
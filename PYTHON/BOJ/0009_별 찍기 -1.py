import sys

num = int(sys.stdin.readline().strip())

for i in range(1, num + 1):
    print(i * "*")

# * 연산자를 쓰지 않는 방법 (출처: ChatGPT)
# def repeat_char(char, times):
#     result = ""
#     for _ in range(times):
#         result += char
#     return result

# # 사용 예시
# print(repeat_char('*', 5))  # 출력: *****
# 여기서 repeat_char 함수는 루프를 사용해 times 횟수만큼 char 문자를 반복해서 result 문자열에 추가합니다.

# 2. 리스트 컴프리헨션과 join() 사용

# def repeat_char(char, times):
#     return ''.join([char for _ in range(times)])

# # 사용 예시
# print(repeat_char('*', 5))  # 출력: *****
# 이 방법에서는 리스트 컴프리헨션을 사용해 times 횟수만큼 char 문자를 가진 리스트를 만들고, join() 메서드를 사용해 이 리스트의 요소를 하나의 문자열로 합칩니다.

# 3. 재귀 함수 사용

# def repeat_char(char, times):
#     if times <= 0:
#         return ""
#     else:
#         return char + repeat_char(char, times - 1)

# # 사용 예시
# print(repeat_char('*', 5))  # 출력: *****
# 이 방법은 재귀적으로 times를 줄여가면서 char 문자를 반복해 나가는 방식입니다. times가 0이 되면 재귀가 종료됩니다.

# 4. map()과 join() 사용

# def repeat_char(char, times):
#     return ''.join(map(lambda _: char, range(times)))

# # 사용 예시
# print(repeat_char('*', 5))  # 출력: *****
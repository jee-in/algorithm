import sys

A_size, X = list(map(int, sys.stdin.readline().split()))
A = list(map(int, sys.stdin.readline().split()))

result = []

# Case 1) 일반적인 for문 방식
for i in range(A_size):
    if (A[i] < X): result.append(A[i])

for r in result:
    print(r, end=' ')

# Case 2) 리스트 컴프리헨션 방식
# [print(r, end=' ') for r in result]

# ChatGPT의 피드백
# 리스트 컴프리핸션 방식은 한 줄로 간단히 표현해야 하는 상황에서 사용할 수 있지만, 
# 비생산적인 리스트 생성과 부수 효과 때문에 일반적으로 추천되지 않습니다. 
# 가독성과 효율성을 유지하려면 가능하면 피하는 것이 좋습니다.


# 맥북 관련 이슈 사항
# print( ,end=' ')처럼 개행을 사용하지 않을 경우 맥북에서는 마지막에 '%'가 출력된다.
# 코드가 끝나고 print()를 수행해주면 이 문제를 해결할 수 있다.
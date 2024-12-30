import sys
input = sys.stdin.readline

# 입력 - 리스트 컴프리핸션 방식
nums = [int(input().strip()) for _ in range(9)]

# 파이썬 내장 함수 max 사용
print(max(nums))
print(nums.index(max(nums)) + 1) # 주어진 입력값 조건이 서로 다른 자연수라서 가능
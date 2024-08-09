# 함수형으로 코딩 시작

import sys

# 여러 줄에 걸쳐 입력된 숫자를 입력받아 리스트로 생성하는 함수
def readlines_to_list():
    return list(map(int, sys.stdin.readlines()))

# 숫자 배열에서 최댓값인 요소를 찾아 그 요소의 인덱스를 반환하는 함수
def index_of_max(nums):
    max_index = 0
    for i in range(1, len(nums)):
        if nums[i] > nums[max_index]: 
            max_index = i
    return max_index

# 입력 받기
nums = readlines_to_list()
max_index = index_of_max(nums)

# 정답 출력
print(nums[max_index])
print(max_index + 1)

# 풀이 방법 (7) 병합 정렬 -- 엄청 느리지만 성공...
import sys

from typing import MutableSequence
def merge_sort(a, left, right):

    if left < right:
        center = (left + right) // 2

        merge_sort(a, left, center)
        merge_sort(a, center + 1, right)

        p = j = 0
        i = k = left

        while i <= center:
            buff[p] = a[i]
            p += 1
            i += 1

        while i <= right and j < p:
            if buff[j] <= a[i]:
                a[k] = buff[j]
                j += 1
            else:
                a[k] = a[i]
                i += 1
            k += 1
        
        while j < p:
            a[k] = buff[j]
            k += 1
            j += 1

if __name__ == '__main__':
    num = int(input())
    a = [int(sys.stdin.readline().rstrip()) for _ in range(num)]

    n = len(a)
    buff = [None] * n                   # 작업용 버퍼 생성
    merge_sort(a, 0, n - 1)
    del buff                            # 작업용 버퍼 삭제

    for number in a:
        print(number)

# 풀이 방법 (6) 퀵 정렬 -- 70%까지 채점하다가 시간 초과
# import sys

# def quick_sort(int_list, left, right):
#     pl = left
#     pr = right
#     pivot = int_list[(left + right) // 2]

#     while pl <= pr:
#         while int_list[pl] < pivot: pl += 1
#         while int_list[pr] > pivot: pr -= 1

#         if pl <= pr:
#             int_list[pl], int_list[pr] = int_list[pr], int_list[pl]
#             pl += 1
#             pr -= 1
    
#     if left < pr: quick_sort(int_list, left, pr)
#     if pl < right: quick_sort(int_list, pl, right)

# if __name__ == '__main__':
#     size = int(sys.stdin.readline().rstrip())
#     int_list = [int(sys.stdin.readline().rstrip()) for _ in range(size)]

#     quick_sort(int_list, 0, len(int_list) - 1)

#     for number in int_list:
#         print(number)


# 풀이 방법 (5) 이진 삽입 정렬

# 풀이 방법 (4) 단순 삽입 정렬


# 풀이 방법 (3) 단순 선택 정렬 - 시간 초과
# import sys

# def selection_sort(int_list):
#     n = len(int_list)

#     for i in range(n-1):
#         min = i
#         for j in range(i + 1, n):
#             if int_list[j] < int_list[min]:
#                 min = j
        
#         int_list[i], int_list[min] = int_list[min], int_list[i]


# if __name__ == '__main__':
#     size = int(sys.stdin.readline().rstrip())
#     int_list = [int(sys.stdin.readline().rstrip()) for _ in range(size)]

#     selection_sort(int_list)

#     for int in int_list:
#         print(int)

# 풀이 방법 (2) 교재 - 셰이커 정렬 - 시간 초과
# import sys

# def shaker_sort(int_list):
#     left = 0                        # 왼쪽 시작 인덱스 초기화
#     right = len(int_list) - 1       # 오른쪽 시작 인덱스 초기화
    
#     last = right
#     while left < right:
#         for j in range(right, left, -1):
#             if int_list[j - 1] > int_list[j]:
#                 int_list[j - 1], int_list[j] = int_list[j], int_list[j - 1]
#                 last = j            
#         left = last                 # [left]번 요소 왼쪽으로는 이미 정렬 완료
        
#         for j in range(left, right):
#             if int_list[j] > int_list[j + 1]:
#                 int_list[j], int_list[j + 1] = int_list[j + 1], int_list[j]
#                 last = j
#         right = last                # [right]번 요소 오른쪽으로는 이미 정렬 완료


# if __name__ == '__main__':
#     size = int(sys.stdin.readline().rstrip())
#     int_list = [int(sys.stdin.readline().rstrip()) for _ in range(size)]

#     shaker_sort(int_list)

#     for int in int_list:
#         print(int)

# 풀이 방법 (1) 교재 기준 가장 최적화된 버블 정렬. 시간 초과
# import sys

# def sorting(int_list):
#     n = len(int_list)

#     k = 0
#     while k < n - 1:
#         last = n - 1
#         for j in range(n - 1, k, -1):
#             if int_list[j - 1] > int_list[j]:
#                 int_list[j - 1], int_list[j] = int_list[j], int_list[j - 1]
#                 last = j
#         k = last


# if __name__ == '__main__':
#     size = int(sys.stdin.readline().rstrip())
#     int_list = [int(sys.stdin.readline().rstrip()) for _ in range(size)]

#     sorting(int_list)

#     for int in int_list:
#         print(int)
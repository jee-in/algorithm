# 출처: https://e-juhee.tistory.com/entry/python-%EB%B0%B1%EC%A4%80-8983-%EC%82%AC%EB%83%A5%EA%BE%BC-%EC%9D%B4%EB%B6%84-%ED%83%90%EC%83%89?category=1097015

import sys

def binary_search(arr, target):
    left, right = 0, len(arr)-1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid+1
        else:
            right = mid - 1
    return right

if __name__ == '__main__':
    m, n, l = map(int, input().split())
    s = list(map(int, input().split()))
    s.sort()

    count = 0
    for _ in range(n):                              
        x, y = map(int, sys.stdin.readline().split())

        idx = binary_search(s, x)

        dist = abs(x - s[idx]) + y
        dist_right = abs(x - s[idx+1]) + y if idx < m-1 else float('inf')

        dist = min(dist, dist_right)

        if dist <= l:
            count += 1

    print(count)

import sys

def binary_search(A: list, X: int):

    left = 0
    right = len(A) - 1

    while left <= right:
        #print(left, right)
        pc = (left + right) // 2

        if A[pc] == X:
            return 1
        elif A[pc] > X:
            right = pc - 1
        elif A[pc] < X:
            left = pc + 1
    
    return 0

N = int(sys.stdin.readline().rstrip())
A = list(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline().rstrip())
X = list(map(int, sys.stdin.readline().split()))

A.sort()

for x in X:
    print(binary_search(A, x))
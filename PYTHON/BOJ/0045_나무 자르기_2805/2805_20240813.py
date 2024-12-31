# 구하고 싶은 값: H의 최댓값
# H에 대해 알고 있는 정보: 가능한 최댓값은 max(trees) - 1
# 조건에 맞는 H가 성립하는 조건: tree in trees 를 H로 뺀 값을 모두 더했을 때 M보다 크면 조건에 맞는 H가 성립

import sys

def find_height(trees, M):
    left = 0
    right = max(trees) - 1

    result = 0
    while left <= right:
        temp_sum = 0
        pc = (left + right) // 2
        print(left, right, pc)
        
        for tree in trees:
            if tree > pc:
                temp_sum += (tree - pc)
        
        if temp_sum == M: 
            result = pc
            return result
        elif temp_sum < M: 
            right = pc - 1
        else:
            result = pc
            left = pc + 1
    
    return result

if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().split())
    trees = list(map(int, sys.stdin.readline().split()))

    print(find_height(trees, M))

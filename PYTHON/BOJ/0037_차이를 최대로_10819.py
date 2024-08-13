import sys

def recursive(first_index, is_used, temp_list):
    if (first_index >= N): 
        #print(temp_list)
        temp_max = 0
        for i in range(N - 1):
            temp_max += abs(temp_list[i + 1] - temp_list[i])
    
        global answer
        answer = max(temp_max, answer)
        return None                        # temp_list의 N-1번 요소까지 채웠을 경우 재귀 함수 탈출 

    # 순열
    for i in range(N):
        if not is_used[i]:
            temp_list[first_index] = int_list[i]

            is_used[i] = True
            recursive(first_index + 1, is_used, temp_list)             
            is_used[i] = False

if __name__ == '__main__':
    
    # 입력 내용 -> 재귀 함수 recur에서 변수로 사용
    N = int(sys.stdin.readline().rstrip())
    int_list = list(map(int, sys.stdin.readline().rstrip().split()))

    answer = 0

    depth = 0
    temp_list = [None] * N
    is_used = [False] * N

    recursive(0, is_used, temp_list)
    print(answer)
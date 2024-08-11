

# 교재 코드
# n = int(input())
# count = 0
# pos = [0] * n

# flag_row = [False] * n
# flag_diagonal_a = [False] * (2*n - 1)
# flag_diagnoal_b = [False] * (2*n - 1)

# def increment_count():
#     global count
#     count += 1
    

# def set_in_row(i):
#     for j in range(n):
#         if(not flag_row[j] and not flag_diagonal_a[i + j] and not flag_diagnoal_b[i - j + 7]):
#             pos[i] = j

#             if i == (n - 1):
#                 increment_count()
#             else:
#                 flag_row[j] = flag_diagonal_a[i + j] = flag_diagnoal_b[i - j + (n - 1)] = True
#                 set_in_row(i + 1)
#                 flag_row[j] = flag_diagonal_a[i + j] = flag_diagnoal_b[i - j + (n - 1)] = False

# set_in_row(0)
# print(count)

# 백트래킹 방법 (Chatgpt가 알려줌)
def nqueen_count(n):
    def place_queens(row):
        """현재 row까지의 퀸 배치 상태에서 유효한 조합을 재귀적으로 찾음"""
        nonlocal count
        
        if row == n:  # 모든 퀸이 성공적으로 배치된 경우
            count += 1
            return
        
        for col in range(n):
            if not flag_row[col] and not flag_diagonal_a[row + col] and not flag_diagonal_b[row - col + n - 1]:
                # 현재 (row, col)에 퀸을 배치
                pos[row] = col
                flag_row[col] = True
                flag_diagonal_a[row + col] = True
                flag_diagonal_b[row - col + n - 1] = True
                
                # 다음 행으로 이동
                place_queens(row + 1)
                
                # 퀸을 제거하고 다음 조합을 위해 상태 복원
                flag_row[col] = False
                flag_diagonal_a[row + col] = False
                flag_diagonal_b[row - col + n - 1] = False

    count = 0
    pos = [0] * n
    flag_row = [False] * n
    flag_diagonal_a = [False] * (2 * n - 1)
    flag_diagonal_b = [False] * (2 * n - 1)

    place_queens(0)
    return count

# 사용자 입력
n = int(input())
print(nqueen_count(n))

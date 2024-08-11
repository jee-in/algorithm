# # 풀이 방법 1 (출처: https://knowable.tistory.com/19)

# def visit(n, r, c):
#     global cnt
#     if n==2:
#         if r == R and c == C:
#             print(cnt)
#             return
#         cnt += 1

#         if r == R and c+1 == C:
#             print(cnt)
#             return
#         cnt += 1

#         if r+1 == R and c == C:
#             print(cnt)
#             return
#         cnt += 1

#         if r+1 == R and c+1 == C:
#             print(cnt)
#             return
#         cnt += 1
#     else:
#         visit(n/2, r, c)
#         visit(n/2, r, c + n/2)
#         visit(n/2, r + n/2, c)
#         visit(n/2, r + n/2, c + n/2)


# cnt = 0
# n, R, C = map(int,input().split(' '))
# visit(2**n, 0, 0)

# # 풀이 방법 2 (출처: https://ggasoon2.tistory.com/11)
# N, r, c = map(int, input().split())

# ans = 0

# while N != 0:

# 	N -= 1

# 	# 제2사분면
# 	if r < 2 ** N and c < 2 ** N:
# 		ans += ( 2 ** N ) * ( 2 ** N ) * 0

# 	# 제1사분면
# 	elif r < 2 ** N and c >= 2 ** N: 
# 		ans += ( 2 ** N ) * ( 2 ** N ) * 1
# 		c -= ( 2 ** N )
        
# 	# 제3사분면    
# 	elif r >= 2 ** N and c < 2 ** N: 
# 		ans += ( 2 ** N ) * ( 2 ** N ) * 2
# 		r -= ( 2 ** N )
        
# 	# 제4사분면    
# 	else:
# 		ans += ( 2 ** N ) * ( 2 ** N ) * 3
# 		r -= ( 2 ** N )
# 		c -= ( 2 ** N )
    
# print(ans)

# # 풀이 방법 3 (출처: https://ggasoon2.tistory.com/11)
# N, r, c = map(int, input().split())

# def sol(N, r, c):

# 	if N == 0:
# 		return 0
        
# 	return 2*(r%2)+(c%2) + 4*sol(N-1, int(r/2), int(c/2))

# print(sol(N, r, c))

# 풀이 방법 4(출처: https://allover3773.gitbook.io/algorithm/basic/z)

# 핵심 아이디어
# 1) half_size = 2**N / 2 로 정의

# 2) 2차원 배열을 4사분면으로 나누기
#   Z 모양으로 2차원 배열을 순회할 때 2차원 배열을 처음으로 4등분한 모양에서
#   - 제1사분면의 첫 번째 칸인 [0, 0]을 방문하는 순서는 0번이다.
#   - 제2사분면의 첫 번째 칸인 [0, half_size]를 방문하는 순서는 (half_size)**2 * 1 번이다.
#   - 제3사분면의 첫 번째 칸인 [half_size, 0]를 방문하는 순서는 (half_size)**2 * 2 번이다.
#   - 제4사분면의 첫 번째 칸인 [half_size, half_size]를 방문하는 순서는 (half_size)**2 * 3 번이다.

# 3) 주어진 [r, c]가 네 개의사분면 중에서 어디에 위치하는지 확인하기
#   현재 확인 중인 box_size(2**N)의 제1사분면의 시작점: [row, col]

#   - 제1사분면 조건: row <= r < row + half_size               , col <= c < col + half_size
#                   -> [row, col]을 [row, col]로 유지
#                   -> 제1사분면의 첫 번째 칸에 방문하는 순서는 num번
#   - 제2사분면 조건: row <= r < row + half_size               , col + half_size <= c < col + size
#                   -> [row, col]을 [row, col + half_size]로 유지
#                   -> 제2사분면의 첫 번째 칸에 방문하는 순서는 num + ((half_size ** 2) * 1)
#   - 제3사분면 조건: row + half_size <= r < row + size        , col <= c < col + half_size
#                   -> [row, col]을 [row + half_size, col]로 유지
#                   -> 제3사분면의 첫 번째 칸에 방문하는 순서는 num + ((half_size ** 2) * 2) 
#   - 제4사분면 조건: row + half_size <= r < row + size        , col + half_size <= c < col + size
#                   -> [row, col]을 [row + half_size, col + half_size]로 유지
#                   -> 제4사분면의 첫 번째 칸에 방문하는 순서는 num + ((half_size ** 2) * 3)

# 4) 주어진 [r, c]가 위치한사분면으로 이동하여 (3)번 과정을 반복함

# 5) half_size가 2가 되었다면 더 이상 (3)을 수행할 수 없음. 최종 순서 출력하기


def Z(row, col, size, no):
    # 박스의 사이즈가 2X2가 되었다면 더 이상 (3)을 수행하지 않고 바로 방문 순서를 출력하면 된다.
    if size == 2:
        if row == r and col == c:           # [row, col]이 제1사분면에 해당할 경우
            print(no)
            return
        no += 1

        if row == r and col + 1 == c:       # [row, col]이 제2사분면에 해당할 경우
            print(no)
            return
        no += 1

        if row + 1 == r and col == c:       # [row, col]이 제3사분면에 해당할 경우
            print(no)
            return
        no += 1

        if row + 1 == r and col + 1 == c:   # [row, col]이 제3사분면에 해당할 경우
            print(no)
            return
        no += 1                             # 이 줄은 출력될 일이 없을 듯...??

    else:
        # 박스를 4분면으로 나눴을 때 한사분면의 가로 및 세로 크기
        half_size = size // 2               # half_size = size / 2 로 하면 소수점까지 출력된다.

        # [r, c]가 제1사분면에 위치하는가?
        if row <= r < row + half_size and col <= c < col + half_size:
            Z(row, col, half_size, no)
        # [r, c]가 제2사분면에 위치하는가?
        elif row <= r < row + half_size and col + half_size <= c < col + 2 * half_size:
            Z(row, col + half_size, half_size, no + 1 * (half_size**2))
        # [r, c]가 제3사분면에 위치하는가?
        elif row + half_size <= r < row + 2 * half_size and col <= c < col + half_size:
            Z(row + half_size, col, half_size, no + 2 * (half_size**2))
        # [r, c]가 제4사분면에 위치하는가?
        elif row + half_size <= r < row + 2 * half_size and col + half_size <= c < col + 2 * half_size:
            Z(row + half_size, col + half_size, half_size, no + 3 * (half_size**2))

N, r, c = map(int, input().split())
Z(0, 0, 2**N, 0)
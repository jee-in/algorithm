
import sys
sys.setrecursionlimit(10**6)  # 재귀 깊이 제한을 크게 설정. 이걸 하지 않으면 계속 런타임 에러가 남.. + ㅡ +

answer = 0
def recur(first, second, third, max_sum):

    if first >= n - 2:
        return
    if second >= n - 1:
        return recur(first + 1, first + 2, first + 3, max_sum)
    if third >= n:
        return recur(first, second + 1, second + 2, max_sum)
    
    #print("현재 탐색 포인트", first, second, third)
    temp_sum = card_list[first] + card_list[second] + card_list[third]
    if temp_sum <= limit:

        global answer
        if max_sum < temp_sum:
            max_sum = temp_sum
            answer = max_sum

            if answer == limit: return

    return recur(first, second, third + 1, max_sum)

N, M = map(int, sys.stdin.readline().split())
card_list = list(map(int, sys.stdin.readline().split()))
card_list.sort(reverse = True)

n = len(card_list)
limit = M

recur(0, 1, 2, 0)
print(answer)


# import sys

# def get_max(card_list, M):
#     def recur(first, second, third, max_sum):
#         if first >= n -2:
#             return max_sum
#         if second >= n - 1:
#             return recur(first + 1, first + 2, first + 3, max_sum)
#         if third >= n:
#             return recur(first, second + 1, second + 2, max_sum)

#         #print("현재 탐색 포인트", first, second, third)
#         if card_list[first] + card_list[second] + card_list[third] > max_sum and card_list[first] + card_list[second] + card_list[third] <= limit:
#             max_sum = card_list[first] + card_list[second] + card_list[third]
#             #print("현재 최대 값:", max_sum)
#             if max_sum == limit: return max_sum

#         return recur(first, second, third + 1, max_sum)

#     n = len(card_list)
#     limit = M
#     max_sum = recur(0, 1, 2, 0)

#     return max_sum

# if __name__ == '__main__':
#     N, M = list(map(int, sys.stdin.readline().rstrip().split()))
#     card_list = list(map(int, sys.stdin.readline().rstrip().split()))

#     print(get_max(card_list, M))

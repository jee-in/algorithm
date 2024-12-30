# 완규님 코드

#카드 조합 생성 함수
#card_lists : 현재까지 선택한 카드들의 조합을 저장
#depth : 현재까지 몇개의 카드를 선택했는지를 확인
#used : 각 카드가 현재 조합에서 사용되었는지 확인
#numbers : 현재까지 생성된 중복되지 않는 숫자의 조합을 저장

def card_game(card_lists, depth, used, numbers):
    #depth가 k일 떄, card_lists에 cards[i]를 추가하고 used[i]를 True로 하면 재귀함수 끝남
    if depth == k:
        #card_lists 에 있는 숫자중 중복되지 않게 numbers에 추가
        if card_lists not in numbers:
            numbers.append(card_lists)
        return
    
    for i in range(n):
        if not used[i]:
            used[i] = True
            card_game(card_lists + cards[i], depth + 1, used, numbers)
            used[i] = False

#카드 개수 입력
n = int(input())
#전체 카드 중 고를 카드의 개수 입력
k = int(input())

#카드 숫자 입력. n번 입력을 받아 각 입력값을 문자열로 리스트에 저장. 
cards = [input().strip() for _ in range(n)]

#카드로 만들어진 조합 저장할 리스트
numbers = []

#재귀함수를 호출하고 끝내기 위해 만듬
used = [False] * n

#재귀함수 호출
card_game("", 0, used, numbers)

# 출처: https://e-juhee.tistory.com/entry/python-%EB%B0%B1%EC%A4%80-5568-%EC%B9%B4%EB%93%9C-%EB%86%93%EA%B8%B0-%EC%9E%AC%EA%B7%80-%ED%95%A8%EC%88%98-vs-itertools-%EB%B9%84%EA%B5%90?category=1097015

# 풀이 방법 (1) 재귀함수

# import time
import sys

def pick(result, n, picked):
    if n == k:
        if result not in card_list:
            card_list.append(result)
        return

    for card_idx in range(len(cards)):
        if card_idx not in picked:
            picked.append(card_idx)
            new_result = result + cards[card_idx]
            pick(new_result, n + 1, picked)
            picked.pop()

n = int(input())
k = int(input())

# start = time.time()
cards = [sys.stdin.readline().strip() for _ in range(n)]
card_list = []

pick("", 0, [])
print(len(card_list))

# end = time.time()
# print("소요 시간:", end - start)

# 풀이 방법 (2) itertools 이용
# import time
# import itertools
# import sys
# n = int(input())
# k = int(input())

# start = time.time()

# cards = [sys.stdin.readline().strip() for _ in range(n)]
# print(len(set(("".join(i) for i in itertools.permutations))))

# end = time.time()
# print("소요 시간:", end - start)
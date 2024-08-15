import sys

#해당 동물이 사냥되는 동물인지 확인하는 함수
#animal : 동물의 위치 (x, y)로 표시됌
#hunters : 사대 위치 리스트 (x 좌표만 포함)
#L : 사정거리
def possible_hunt(animal, hunters, L):

    #동물의 위치를 기준으로 오른쪽, 왼쪽에 사정거리 L 내에 사대가 있는지 확인
    left = animal[0] - (L - animal[1])
    right = animal[0] + (L - animal[1])

    #hunters 리스트의 양 끝 값을 기준으로 이분탐색 시작
    start, end = 0, len(hunters) - 1

    #이분탐색을 통해 사정거리 내에 사대가 있는지 확인
    while start <= end:
        #중간 지점 계산
        mid = (start + end) // 2

        #hunters[mid]값이 left와 right 사이에 있으면 동물을 사냥할 수 있음
        if hunters[mid] < left:
            start = mid + 1
        elif hunters[mid] > right:
            end = mid - 1
        else:
            return True #사정거리 내에 사대가 존재
    return False #사정거리 내에 사대가 없음

def hunted_animals(hunters, animals, L):
    #사냥 된 동물의 수를 세기 위한 변수
    hunted_count = 0
    for animal in animals:
        if possible_hunt(animal, hunters, L):
            hunted_count += 1
    return hunted_count

# M : 사대 개수
# N : 동물의 마리 수
# L : 사정거리
M, N, L = map(int, sys.stdin.readline().split())

# Hunter_location : 사대 위치 리스트 (x 좌표만 포함)
Hunter_location = list(map(int, sys.stdin.readline().split()))
# Animal_location : 동물의 위치 리스트 (x, y)로 표시
Animal_location = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

#사대 위치를 기준으로 이분탐색하기 위해 오름차순 정렬
Hunter_location.sort()

#hunted_animals의 반환값으로 나온 사냥된 동물 수를 H에 저장
H = hunted_animals(Hunter_location, Animal_location, L)
print(H)
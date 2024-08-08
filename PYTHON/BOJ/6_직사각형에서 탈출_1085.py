import sys

list = list(map(int, sys.stdin.readline().split()))
x, y, w, h = list

# Case 1) 최대, 최소값 구하는 라이브러리 사용
# Case 2) if문 세 번 사용

minimum_x = x if x < w - x else w - x
minimum_y = y if y < h - y else h - y

mininum_distance = minimum_x if minimum_x < minimum_y else minimum_y

print(mininum_distance)

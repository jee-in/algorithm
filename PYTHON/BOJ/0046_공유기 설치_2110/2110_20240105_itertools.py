import sys
from itertools import combinations

input = sys.stdin.readline

def calculate_minimum(installed):
    minimum = float('inf')
    for i in range(1, len(installed)):
        gap = installed[i] - installed[i - 1]
        minimum = min(minimum, gap)
    return minimum

def find_maximum_min_distance(houses, C):
    max_distance = 0
    for installed in combinations(houses, C):
        max_distance = max(max_distance, calculate_minimum(installed))
    return max_distance

if __name__ == '__main__':
    N, C = map(int, input().split())
    houses = sorted(int(input().strip()) for _ in range(N))
    print(find_maximum_min_distance(houses, C))
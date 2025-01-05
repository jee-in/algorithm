import sys

input = sys.stdin.readline

def calculate_minimum(installed):
    minimum = float('inf')
    for i in range(1, len(installed)):
        gap = installed[i] - installed[i - 1]
        minimum = min(minimum, gap)
    return minimum

def generate_combinations(houses, depth, start, installed, max_distance):
    if depth == 0:
        max_distance[0] = max(max_distance[0], calculate_minimum(installed))
        return

    for i in range(start, len(houses)):
        installed.append(houses[i])
        generate_combinations(houses, depth - 1, i + 1, installed, max_distance)
        installed.pop()

def find_maximum_min_distance(houses, C):
    max_distance = [0]
    generate_combinations(houses, C, 0, [], max_distance)
    return max_distance[0]

if __name__ == '__main__':
    N, C = map(int, input().split())
    houses = sorted(int(input().strip()) for _ in range(N))
    print(find_maximum_min_distance(houses, C))
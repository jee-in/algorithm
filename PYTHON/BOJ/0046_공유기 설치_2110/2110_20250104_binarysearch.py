import sys
input = sys.stdin.readline

def can_install(houses, C, min_distance):
    count = 1
    last_installed = houses[0]

    for i in range(1, len(houses)):
        if houses[i] - last_installed >= min_distance:
            count += 1
            last_installed = houses[i]
            if count >= C: return True
    
    return False

def find_max_min_distance(houses, C):
    left = 1
    right = houses[-1] - houses[0]
    result = 0

    while left <= right:
        mid = (left + right) // 2

        if can_install(houses, C, mid):
            result = mid
            left = mid + 1
        else: right = mid - 1

    return result

if __name__ == '__main__':
    N, C = map(int, input().split())
    houses = [int(input().strip()) for _ in range(N)]
    houses.sort()

    print(find_max_min_distance(houses, C))
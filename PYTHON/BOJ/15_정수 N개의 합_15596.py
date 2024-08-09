# 내장 함수 sum() 사용 -> 백준 시간: 28ms
def solve(a: list):
    return sum(a)

# 반복문 사용 -> 백준 시간: 100ms
def solve(a: list):
    total = 0
    for num in a:
        total += num
    return total
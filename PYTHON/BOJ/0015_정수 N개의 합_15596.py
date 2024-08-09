# 내장 함수 sum() 사용 -> 백준 시간: 28ms
def solve(a: list):
    return sum(a)

# 파이썬의 내장 함수 sum()은 C로 구현되어 있어 매우 최적화되어 있습니다. C로 작성된 코드는 파이썬의 인터프리터에서 동작하는 일반적인 파이썬 코드보다 훨씬 빠르게 실행됩니다.

# 반복문 사용 -> 백준 시간: 100ms
def solve(a: list):
    total = 0
    for num in a:
        total += num
    return total
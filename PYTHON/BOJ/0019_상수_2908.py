# A, B = input().split()

# Case 1) max() 함수 사용 -> 백준 시간: 40ms
def get_sangsu_result(A, B):
    return max(A[::-1], B[::-1])

# Case 2) 조건부 표현식 방법 사용 -> 백준 시간: 32ms
# def get_sangsu_result(A, B):
#     sangsu_a, sangsu_b = A[::-1], B[::-1]
#     return sangsu_a if sangsu_a > sangsu_b else sangsu_b

print(get_sangsu_result(A, B))
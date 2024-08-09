# 참고 자료
# Do it! 자료구조와 함께 배우는 알고리즘 입문 > 2장 기본 자료 구조와 배열 > 소수 나열하기

N = int(input())
nums = list(map(int, input().split()))

# N 이하의 소수를 담은 배열을 생성하는 함수
def get_prime_list(N):
    prime_list = [None] * 500
    list_pointer = 0

    prime_list[list_pointer] = 2
    list_pointer += 1
    prime_list[list_pointer] = 3
    list_pointer += 1

    for i in range (5, N + 1, 2):
        j = 1
        while prime_list[j] * prime_list[j] <= i:
            if i % prime_list[j] == 0: break
            j += 1
        else:
            prime_list[list_pointer] = i
            list_pointer += 1

    return prime_list[:list_pointer]

prime_list = get_prime_list(1000)           # 1000 이하의 소수를 담은 리스트 생성
prime_count = 0
for i in range(N):
    if nums[i] in prime_list:               # 입력받은 숫자가 소수 리스트에 있는지 없는지 검사
        prime_count += 1

print(prime_count)
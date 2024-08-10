import math

# 정태우님 코드 참고
# Case 1: is_prime() 함수를 만들어서 사용
def is_prime(num):
    if num == 1: return False
    if num == 2: return True
    if num == 3: return True
    for i in range(2, int(math.sqrt(num)) + 1): 
        if num % i == 0: 
            return False
    return True

test_num = int(input())
for i in range(test_num):
    even = int(input())

    end = math.floor(even / 2)
    while True:
        if is_prime(end) and is_prime(even - end): 
            print(end, even -end)
            break
        end -= 1


# Case 2: is_prime() 여부를 담은 체를 생성하여 사용

# Case 3: 10000 이하의 모든 소수를 담은 소수 배열 만들기
# 시간 초과...
# def get_prime_list(N):
#     prime_list = [None] * 5000
#     list_pointer = 0

#     prime_list[list_pointer] = 2
#     list_pointer += 1
#     prime_list[list_pointer] = 3
#     list_pointer += 1

#     for i in range (5, N + 1, 2):
#         j = 1
#         while prime_list[j] * prime_list[j] <= i:
#             if i % prime_list[j] == 0: break
#             j += 1
#         else:
#             prime_list[list_pointer] = i
#             list_pointer += 1
#     return prime_list[:list_pointer]

# prime_list = get_prime_list(10000)

# def get_components(even):
#     i = 0
#     list = []
#     while prime_list[i] <= even / 2:
#         if even - prime_list[i] in prime_list:
#             list = [prime_list[i], even-prime_list[i]]
#         i += 1
#     return list


# test_num = int(input())
# for n in range(test_num):
#     even = int(input())
#     list = get_components(even)

#     print(*list, sep=' ')
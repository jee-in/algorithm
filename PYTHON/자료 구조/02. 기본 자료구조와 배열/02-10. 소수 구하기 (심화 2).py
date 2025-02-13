# N이하의 소수 구하기

# 목표: 소수를 구하는 과정에서 시행되는 불필요한 나눗셈 횟수를 줄이기
# 핵심 아이디어: 
#   심화 1에서 썼던 아이디어에 더하여 한 가지 아이디어를 추가한다.
#   N이 합성수라면 N의 제곱근 이하의 숫자는 N의 제곱근 이상의 숫자와의 곱이다. 
#   따라서 N의 제곱근 이하의 숫자에 대해서만 소수 검증을 진행하면 된다.
# 구현 방법:
#   소수 검증의 대상인 N에 대하여 N 이하의 소수로만 나눠보는 것에서 더 나아가서
#    N 이하의 소수 중에서도 N 제곱근 이하의 수로만 나눠본다.

import math    

def get_prime(N):

    mul_div_counter = 0                            # 시간 복잡도 측정 지표

    prime_list = [None] * 500                       # 소수임이 검증된 숫자를 담을 리스트
    list_pointer = 0                                # prime_list의 마지막 요소의 다음 요소의 인덱스 (소수 개수)

    prime_list[list_pointer] = 2                    # 유일한 짝수 소수인 2를 미리 prime_list에 담기
    list_pointer += 1                               # 소수 배열의 포인터를 1로 이동

    prime_list[list_pointer] = 3                    # 3의 제곱근인 1.xx 이하의 소수는 없으므로 미리 prime_list에 담기
    list_pointer += 1                               # 소수 배열의 포인터를 2로 이동

    # Case 1) prime_list[j] * prime_list[j] <=  N 사용
    for i in range(5, N + 1, 2):
        j = 1                                       # j가 0일 때는 prime_list[0]은 2인데 홀수는 하상 2로 나눠질 수 없으므로 i를 나누는 소수 목록에서 제외

        # None type error가 발생할 일은 없을까....??
        while prime_list[j] * prime_list[j] <= i:   # i의 제곱근보다 작은 prime_list[j]로만 i를 나눠본다는 조건을 이와 같이 표현함 
            mul_div_counter += 2                    # while문에서 한 번, if문에서 한 번 곱셈 및 나눗셈을 시행함
            if i % prime_list[j] == 0: break
            j += 1                                  # while문이므로 j를 1씩 직접 증가시킴
            
            print(f"{i}, {prime_list[j]}, {j}, {list_pointer}")
        else:
            prime_list[list_pointer] = i            # prime_list에 소수 담기
            list_pointer += 1                       # list_pointer 1 증가시키기
            mul_div_counter += 1                    # while문을 빠져나왔기 때문에 나눗셈만 집계
        
    print(f"{N} 이하의 소수 개수는 {list_pointer}개입니다.")
    print(f"소수의 개수를 구하기 위해 시행한 총 나눗셈 횟수: {mul_div_counter}")    
        
    return prime_list[:list_pointer]

    # Case 2) math.sqrt(N) 사용
    # for i in range(5, N + 1, 2):
    #     j = 0
    #     while j < list_pointer and prime_list[j] <= int(math.sqrt(i)):
    #         mul_div_counter += 2
    #         if i % prime_list[j] == 0: break
    #         j += 1
    #     else:
    #         prime_list[list_pointer] = i
    #         list_pointer += 1
    #         mul_div_counter += 1
        

    # print(f"{N} 이하의 소수 개수는 {list_pointer}개입니다.")
    # print(f"소수의 개수를 구하기 위해 시행한 총 나눗셈 횟수: {mul_div_counter}")    
        
    # return prime_list[:list_pointer]

print(get_prime(1000))
# N이 1000일 때 시행된 총 나눗셈 횟수: 
#   - Case 1: 3774
#   - Case 2: 3774
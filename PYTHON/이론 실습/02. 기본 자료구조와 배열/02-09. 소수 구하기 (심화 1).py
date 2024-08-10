# N이하의 소수 구하기

# 목표: 소수를 구하는 과정에서 시행되는 불필요한 나눗셈 횟수를 줄이기
# 핵심 아이디어: 
#   소수인지 확인하고 싶은 숫자를 합성수로 나눠보는 계산은 불필요함. 대상 숫자를 소수로만 나눠보면 됨.
# 구현 방법:
#   1. 홀수만 대상으로 소수 검증하기 
#   2. 소수를 찾을 때마다 배열에 소수를 저장하여 소수 검증에 활요하기

def get_prime(N):
    division_count = 0                              # 시간 복잡도 측정 지표
    
    prime_list = [None] * 500                       # 소수임이 검증된 숫자를 담을 리스트
    list_pointer = 0                                # prime_list의 마지막 요소의 다음 요소의 인덱스 (소수 개수)

    prime_list[list_pointer] = 2                    # 유일한 짝수 소수인 2를 미리 prime_list에 담기
    list_pointer += 1                               # 소수 배열의 포인터를 1로 이동

    for i in range(3, N + 1, 2):                    # 구현 방법 1. N 이하의 '홀수'만 대상으로 소수 검증하기
        for j in range(1, list_pointer):            # 구현 방법 2. i를 i 이하의 소수 배열에 있는 소수로만 나눠보기 (단, 소수 배열 중 2로는 나눠볼 필요 없음)
            division_count += 1
            if i % prime_list[j] == 0: break        # i가 j로 나누어지면 i는 합성수임
        else:                                       # i가 j 반복문을 정상적으로 탈출했다면 i는 소수임
            prime_list[list_pointer] = i            # prime_list에 소수 i 추가하기
            list_pointer += 1                       # prime_list의 인덱스를 1 증가시키기
    
    print(f"{N} 이하의 소수 개수는 {list_pointer}개입니다.")
    print(f"소수의 개수를 구하기 위해 시행한 총 나눗셈 횟수: {division_count}")
    
    return prime_list[:list_pointer]

print(get_prime(1000))
# N이 1000일 때 시행된 총 나눗셈 횟수: 14622
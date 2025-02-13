# N이하의 소수 구하기


def get_prime(N):
    division_count = 0                      # 시간 복잡도 측정 지표
    prime_count = 0                         # N 이하의 소수 개수

    for i in range(2, N + 1):               # i: 소수인지 확인하고 싶은 대상이 되는 2 ~ 1000까지의 숫자
        for j in range(2, i):               # j: i가 소수인지 확인하기 위하여 i를 나눠보기 위한 2부터 i까지의 숫자
            division_count += 1             # 나눗셈 횟수 카운트
            if i % j == 0: break;           # i가 j로 나눠진다면 i는 소수가 아니라 합성수임. i에 대한 j 반복문 조기 종료
        
        else:                               # for-else 구문: 반복문을 정상적으로 빠져나왔을 때 수행됨
            prime_count += 1                # j 반복문을 탈출한 i는 소수임
            print(i)
    
    print(f"{N} 이하의 소수 개수는 {prime_count}개입니다.")    
    print(f"소수의 개수를 구하기 위해 시행한 총 나눗셈 횟수: {division_count}")
    
get_prime(1000)
# N이 1000일 때 시행된 총 나눗셈 횟수: 78022

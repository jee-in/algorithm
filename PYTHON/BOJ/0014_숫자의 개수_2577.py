import sys

A = int(sys.stdin.readline().strip())
B = int(sys.stdin.readline().strip())
C = int(sys.stdin.readline().strip())

product = A * B * C

# product에 있는 0 ~ 9의 개수를 담을 10개 크기의 리스트 생성
result = [0] * 10

# 문자열 형태로 되어 있는 숫자에서 
def count_num(string):
    for i in range(len(string)):
        result[int(string[i])] += 1
    return result


# 결과 출력
for c in count_num(str(product)):
    print(c)
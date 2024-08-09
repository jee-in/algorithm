test_num = int(input())

# 문자열의 각 문자를 repeat 수만큼 반복한 문자열을 반환하는 함수
def multiple_char(string, repeat):
    result = ''
    for s in string:
        result += s * repeat
    return result

for i in range(test_num):
    line = input().split()
    repeat = int(line[0])
    string = line[1]

    print(multiple_char(string, repeat))

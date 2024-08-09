import sys

string = sys.stdin.readline().strip()       # 앞뒤 공백 제거

def get_word_num(string):
    if string == '': return 0               # 빈 문자열일 경우 예외 처리

    word_num = 1
    for s in string:
        if s == ' ':
            word_num += 1
    return word_num

print(get_word_num(string))
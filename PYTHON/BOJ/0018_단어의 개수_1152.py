import sys

string = sys.stdin.readline().strip()

def get_word_num(string):
    if string == '': return 0

    word_num = 1
    for s in string:
        if s == ' ':
            word_num += 1
    return word_num

print(get_word_num(string))
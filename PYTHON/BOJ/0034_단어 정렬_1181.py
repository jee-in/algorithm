import sys

n = int(sys.stdin.readline().rstrip())
word_list = [sys.stdin.readline().rstrip() for _ in range(n)]

word_list = list(set(word_list))
word_list.sort()
word_list.sort(key = len)

for word in word_list:
    print(word)


# 시간 초과
# def collect_words_info(words):
#     n = len(words)

#     # 단어의 길이 정보, 첫 문자의 알파벳 정보를 담은 words_info 리스트 생성
#     words_info = []
#     for i in range(n):
#         word = words[i]
#         word_info = {
#                     'word' : word, 
#                     'len': len(word), 
#                     'ord': ord(word[0])
#                     }
#         words_info.append(word_info)

#     return words_info

# def sort_words(words_info):
#     n = len(words_info)

#     # 길이를 기준으로 오름차순 정렬
#     # 버블 정렬
#     for i in range(n - 1):
#         for j in range(n - 1, i, -1):
#             if words_info[j - 1]['len'] > words_info[j]['len']:
#                 words_info[j - 1], words_info[j] = words_info[j], words_info[j - 1]
    
#     # 같은 길이인 단어는 첫 글자의 알파벳 순으로 오름차순 정렬
#     start_index = 0
#     for i in range(1, n - 1):
#         end_index = i

#         if words_info[i]['len'] != words_info[i - 1]['len']:
#             # 버블 정렬 시작
#             for j in range(start_index, end_index - 1):

#                 for k in range(end_index - 1, j, -1):
#                     if words_info[j - 1]['ord'] > words_info[j]['ord']:
#                         words_info[j - 1], words_info[j] = words_info[j], words_info[j - 1]
                
#                 start_index = end_index + 1

# if __name__ == '__main__':
#     N = int(input())
#     words = []
#     for _ in range(N):
#         word = sys.stdin.readline().rstrip()
#         if word in words: continue              # 이미 입력받은 적 있는 단어는 단어 리스트에 저장하지 않음
#         words.append(word)

#     words_info = collect_words_info(words)
#     sort_words(words_info)

#     for i in range(len(words_info)):
#         print(words_info[i]['word'])
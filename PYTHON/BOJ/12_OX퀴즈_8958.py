import sys

def total_score(quiz_result):
    total_score = 0    
    temp_score = 0
    for i in range(len(quiz_result)):
        if quiz_result[i] == 'O': 
            temp_score += 1                 
            total_score += temp_score       # 해당 퀴즈의 점수는 'O'를 연속 득점한 횟수
        else:
            temp_score = 0                  # 'X'가 나오면 연속 득점 점수가 초기화됨
    return total_score

quiz_num = int(sys.stdin.readline())
for i in range (quiz_num):
    quiz_result = sys.stdin.readline().strip() # '\n'도 문자열 길이에 잡히므로 주의
    print(total_score(quiz_result))
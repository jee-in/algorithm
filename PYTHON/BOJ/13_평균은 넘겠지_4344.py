import sys

# 입력 첫 번째 줄에 있는 케이스 수
case_num = int(sys.stdin.readline())

def average(scores):
    return sum(scores) / len(scores)

def above_average_percent(scores):
    average_score = average(scores)

    above_average_num = 0
    for s in scores:
        if s > average_score: 
            above_average_num += 1
    
    return round(above_average_num / len(scores) * 100, 3)

# 정답 출력
for i in range(case_num):
    # 입력 두 번째 줄부터 나오는 학생 수와 점수 분포
    line2 = list(map(int, sys.stdin.readline().split()))
    student_num = line2[0]
    scores = line2[1:]

    print(f"{above_average_percent(scores)}%")
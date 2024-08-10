import sys

# 종이를 자르는 점선 위치를 방향별로 리스트에 저장하는 딕셔너리를 생성하는 함수
def get_cuts_list(x, y, cut_count):
    cuts = {                                                        
        "horizontal_lines" : [],                                            # 가로 방향 점선 위치의 리스트
        "vertical_lines" :[]                                                # 세로 방향 점선 위치의 리스트
    }

    cuts["horizontal_lines"] = [0, y]                                       # 점선 위치의 리스트에 시작점과 끝점을 미리 저장               
    cuts["vertical_lines"] = [0, x]

    for i in range(cut_count):                                              # cut_count만큼 반복하며 자르는 점선 위치를 리스트에 저장
        dir, no = list(map(int, sys.stdin.readline().split()))
        if dir == 0: 
            cuts["horizontal_lines"].append(no)                             # 가로 방향 점선 위치의 리스트에 위치 저장
        else: 
            cuts["vertical_lines"].append(no)                               # 세로 방향 점선 위치의 리스트에 위치 저장
    
    return cuts

# 종이를 자르는 점선 위치 리스트를 가지고 가장 큰 종이 조각의 면적을 구하는 함수
def get_largest_piece_dimension(cuts):
    cuts["horizontal_lines"] = sorted(cuts["horizontal_lines"])             # 점선 위치를 담은 리스트를 오름차순으로 정렬
    cuts["vertical_lines"] = sorted(cuts["vertical_lines"])
    
    max_height = cuts["horizontal_lines"][1] - cuts["horizontal_lines"][0]  # max_height, max_width 초기화
    max_width = cuts["vertical_lines"][1] - cuts["vertical_lines"][0]

    for i in range(2, len(cuts["horizontal_lines"])):                       # max_height 구하기
        max_height = max(max_height, cuts["horizontal_lines"][i] - cuts["horizontal_lines"][i - 1])

    for i in range(2, len(cuts["vertical_lines"])):                         # max_width 구하기
        max_width = max(max_width, cuts["vertical_lines"][i] - cuts["vertical_lines"][i - 1])

    return max_height * max_width


# 직사각형 종이의 가로, 세로 입력 받기
x, y = list(map(int, sys.stdin.readline().split()))

# 종이를 자르는 횟수 입력 받기
cut_count = int(sys.stdin.readline().rstrip())

# 자르는 점선의 위치를 입력받아 리스트로 생성
cuts = get_cuts_list(x, y, cut_count)
print(get_largest_piece_dimension(cuts))
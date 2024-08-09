A, B, V = list(map(int, input().split()))

def get_time_to_reach_peak(day_moving, night_moving, height):
    provided_success_position = height - day_moving                         # 성공 보장 지점: 다음날 무조건 정상에 도달할 수 있는 최저 지점
    one_day_moving = day_moving - night_moving
    
    day_count = provided_success_position // one_day_moving                 # 소요되는 날은 적어도 이 수치보다는 큼
    
    if provided_success_position % one_day_moving == 0: day_count += 1      # 전날 성공 보장 지점에 도착한 경우 다음날 정상에 도착
    else: day_count += 2                                                    # 다음날 성공 보장 지점을 넘을 수 있는 경우 그 다음날 정상에 도착

    return day_count

print(get_time_to_reach_peak(A, B, V))
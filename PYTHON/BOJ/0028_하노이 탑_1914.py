def hanoi(source, target, plate_no):

    if (plate_no < 1): return
    
    # plate_no번 원판 위에 있는 원판(들)을 가운데 기둥으로 옮김
    hanoi(source, 6-source-target, plate_no - 1)

    # plate_no번 원판을 3번 기둥으로 옮김
    print_string.append(f"{source} {target}")
    count += 1

    # 가운데 기둥에 있는 1 ~ (plate_no)개 원판을 3번 기둥으로 옮김
    hanoi(6-source-target, target, plate_no - 1)

    return

num = int(input())
count = 0
print_string = []
hanoi(1, 3, num)
print(count)
if (count < 20):
    print("\n".join(print_string.rstrip()))
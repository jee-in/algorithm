def asc_sort(int_list):

    N = len(int_list)

    # 선택 정렬
    for i in range(N):
        min = int_list[i]
        
        for j in range(i + 1, N):
            if int_list[j] < min:
                min = int_list[j]
                #print(f"int_list[{j}] 자리에 있는 {int_list[j]}를 int_list[{i}] 위치로 옮깁니다.")
                temp = int_list[j]
                int_list[j] = int_list[i]
                int_list[i] = temp
        #print(f"정렬 후: int_list[{i}]: {int_list[i]}")

    return int_list

N = int(input())

int_list = [0] * N
for i in range(N):
    int_list[i] = int(input())

sorted_list = asc_sort(int_list)
for num in int_list:
    print(num)
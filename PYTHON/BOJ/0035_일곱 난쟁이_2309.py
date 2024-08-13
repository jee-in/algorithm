# 태우님 코드

import sys

def recur(start_index, compared_index):
    
    if start_index >= 8:
        return None
    if compared_index >= 9:
        return recur(start_index + 1, start_index + 2)
    if dwarfs[start_index] + dwarfs[compared_index] == difference:
        return start_index, compared_index
    return recur(start_index, compared_index + 1)

dwarfs = [int(sys.stdin.readline().rstrip()) for _ in range(9)]
dwarfs.sort()

sum = 0
for dwarf in dwarfs:
    sum += dwarf
difference = sum - 100

fake1, fake2 = recur(0, 1)
dwarfs.pop(fake2)
dwarfs.pop(fake1)

for d in dwarfs:
    print(d)

# 함수형
# def find_real(dwarfs):

#     def recur(start_index, compared_index):
        
#         if start_index >= 8:
#             return None
#         if compared_index >= 9:
#             return recur(start_index + 1, start_index + 2)
#         if dwarfs[start_index] + dwarfs[compared_index] == difference:
#             return start_index, compared_index
#         return recur(start_index, compared_index + 1)

#     sum = 0
#     for dwarf in dwarfs:
#         sum += dwarf
#     difference = sum - 100

#     fake1, fake2 = recur(0, 1)
#     dwarfs.pop(fake2)
#     dwarfs.pop(fake1)

#     return dwarfs

# if __name__ == '__main__':
#     input_dwarfs = [int(sys.stdin.readline().rstrip()) for _ in range(9)]
#     real_dwarfs = find_real(sorted(input_dwarfs))

#     for real_dwarf in real_dwarfs:
#         print(real_dwarf)
    
# 비재귀적인 코드
# def find_real(dwarfs):
#     height_sum = sum(dwarfs)
#     difference = height_sum - 100

#     for i in range(8):
#         for j in range(i + 1, 9):
#             #print(f"현재 j: {j}")
#             if dwarfs[i] + dwarfs[j] == difference:
#                 #print("발견!")
#                 del dwarfs[j]
#                 del dwarfs[i]

#                 return

# if __name__ == '__main__':
#     dwarfs = [int(sys.stdin.readline().rstrip()) for _ in range(9)]

#     dwarfs.sort()
#     find_real(dwarfs)

#     for d in dwarfs:
#         print(d)
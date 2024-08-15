import sys
input = sys.stdin.readline

N = int(input())
array = [0] * 10001

for i in range(N):
    num = int(input())
    array[num] += 1

for j in range(1, 10001):
    if (array[j] != 0):
        for _ in range(array[j]):
            print(j)


# # 완규님 코드
# def counting_sort(a, max):
#     n = len(a)
#     frequency = [0] * (max + 1)
#     buffer = [0] * n

#     for i in range(n): frequency[a[i]] += 1
#     for i in range(1, max + 1): frequency[i] += frequency[i - 1]
#     for i in range(n - 1, -1, -1): frequency[a[i]] -= 1; buffer[frequency[a[i]]] = a[i]
#     for i in range(n): a[i] = buffer[i]

# if __name__ == '__main__':
#     num = int(input())

#     frequency = [0] * 10001

#     # 0 또는 양수만 입력받도록 입력을 제한
#     for i in range(num):
#         frequency[int(sys.stdin.readline().rstrip())] += 1

#     for i in range(10001):
#         for j in range(frequency[i]):
#             print(i)

# 교재 코드 ... 메모리 초과
# def counting_sort(a, max):
#     n = len(a)
#     frequency = [0] * (max + 1)
#     buffer = [0] * n

#     for i in range(n): frequency[a[i]] += 1
#     for i in range(1, max + 1): frequency[i] += frequency[i - 1]
#     for i in range(n - 1, -1, -1): frequency[a[i]] -= 1; buffer[frequency[a[i]]] = a[i]
#     for i in range(n): a[i] = buffer[i]

# if __name__ == '__main__':
#     num = int(input())

#     a = [None] * num

#     # 0 또는 양수만 입력받도록 입력을 제한
#     for i in range(num):
#         while True:
#             a[i] = int(sys.stdin.readline().rstrip())
#             if a[i] >= 0: break

#     n = len(a)
#     counting_sort(a, max(a))

#     for number in a:
#         print(number)
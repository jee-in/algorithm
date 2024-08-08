import sys

num = int(sys.stdin.readline().strip()) # strip()이 없어도 코드가 동작하기는 함

for i in range(num):
    AB = list(map(int, sys.stdin.readline().split()))
    A, B = AB
    print(A + B)
def shell_sort(a):
    n = len(a)
    h = 1

    while h < n // 9:
        h = h * 3 + 1

    while h > 0:
        for i in range(h, n):
            j = i - h
            tmp = a[i]
            while j >= 0 and a[j] > tmp:
                a[j + h] = a[j]
                j -= h
            a[j + h] =tmp
        h //= 3

num = int(input())
a = []

for i in range(num):
    m = int(input())
    a.append(m)

shell_sort(a)

for i in range(num):
    print(a[i])
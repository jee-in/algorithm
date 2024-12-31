import sys
input = sys.stdin.readline

n, m = map(int, input().split())
heights = list(map(int, input().split()))

def get_max(heights):
    pl = 0
    pr = max(heights)

    while pl <= pr:
        pc = (pl + pr) // 2
        cut_sum = sum(h - pc for h in heights if h > pc)
        print(pl, pr, pc, cut_sum)

        if cut_sum >= m:
            pl = pc + 1
            print('pl', pl)
        else:
            pr = pc - 1
            print('pr', pr)

    return pr

print(get_max(heights))

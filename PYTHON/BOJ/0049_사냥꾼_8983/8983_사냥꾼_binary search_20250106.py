import sys
input = sys.stdin.readline

def can_capture(shooters, animal, shooting_range):
  count = 0
  for i in range(len(shooters)):
    s = shooters[i]
    if animal[2] != 1 and abs(s - animal[0]) + animal[1] <= shooting_range:
      count += 1
      animal[2] = 1
  return count

if __name__ == '__main__':
  M, N, L = map(int, input().split())
  shooters = list(map(int, input().split()))
  shooters.sort()

  count = 0
  animals = [None] * N
  for i in range(N):
    animals[i] = list(map(int, input().split())) + [0]
    count += can_capture(shooters, animals[i], L)
  print(count)

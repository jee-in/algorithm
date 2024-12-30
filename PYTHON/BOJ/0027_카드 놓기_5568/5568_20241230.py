import sys
input = sys.stdin.readline

def recursive(cards, selection, depth, is_visited, combination_set, combination):
  if depth == selection:
    combination_set.add(combination)
    return

  for i in range(len(cards)):
    if (is_visited[i] == False):
      is_visited[i] = True
      recursive(cards, selection, depth + 1, is_visited, combination_set, cards[i] + combination)
      is_visited[i] = False

n = int(input().strip())
k = int(input().strip())

cards = [input().strip() for _ in range(n)]
is_visited = [False] * (n)
combination_set = set()

recursive(cards, k, 0, is_visited, combination_set, "")
print(len(combination_set))

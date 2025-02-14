import sys
input = sys.stdin.readline

def is_ppap(string):

  stack = []
  
  for i in range(len(string)):
    stack.append(string[i])
    while len(stack) >= 4:
      if stack[-4:] == ['P', 'P', 'A', 'P']:
        for _ in range(3): stack.pop()
      else:
        break
  
  if len(stack) == 1 and stack[0] == "P":
    return "PPAP"
  else: return "NP"


if __name__ == "__main__":
  string = input().strip()
  print(is_ppap(string))
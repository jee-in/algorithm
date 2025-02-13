blank1 = []
blank2 = None

print(bool(blank1)) # False 
print(bool(blank2)) # False

if blank1:
  print(True)
else:
  print(False)

if blank2:
  print(True)
else:
  print(False)

if not blank1:
  print(False)

if not blank2:
  print(False)
import copy

a = [1, 2, [3, 4]]
shallow = copy.copy(a)
deep = copy.deepcopy(a)
new = a[:]

# 얕은 복사
print(a is shallow)         # False
print(a[2] is shallow[2])   # True -> 내부 리스트는 같은 객체를 참조

a[2].append(5)              
print(shallow)              # [1, 2, [3, 4, 5]]

# 깊은 복사
print(a is deep)            # False
print(a[2] is deep[2])      # False

a[2].append(5)
print(deep)                 # [1, 2, [3, 4]]


print(a is new)             # False
print(a[2] is new[2])       # True

a[2].append(5)
print(new)                  # [1, 2, [3, 4, 5, 5, 5]]       
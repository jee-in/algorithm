# def factorial(num):
#     result = 1
#     for i in range(1, num + 1):
#         result *= i
    
#     return result

def factorial(num):
    if num == 0: 
        return 1
    
    #print(f"factorial({num}) = {num} * factorial({num} - 1)")
    return num * factorial(num - 1)

num = int(input())
print(factorial(num))

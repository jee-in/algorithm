def recursive_chatbot(num, counter):

    if num == 0:                                                             # 재귀함수 중단 지점
        print('____' * counter + '"재귀함수가 뭔가요?"')
        print('____' * counter + '"재귀함수는 자기 자신을 호출하는 함수라네"')
        print('____' * counter + '라고 답변하였지.')
        return

    print('____' * counter + '"재귀함수가 뭔가요?"')
    print('____' * counter + '"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.')
    print('____' * counter + '마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.')
    print('____' * counter + '그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."')

    counter += 1                                                             # 첫 번째 재귀함수 수행부터 마지막 재귀함수 수행까지 수행됨
    recursive_chatbot(num - 1, counter)
    counter -= 1                                                             # 재귀함수 중단 지점에 도착한 뒤 빠져나올 때 차례대로 수행됨
    print('____' * counter + '라고 답변하였지.')                                 
    
    return

num = int(input())
print('어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.')

counter = 0                             # 재귀함수 순회 순서를 표시하기 위한 카운터
recursive_chatbot(num, counter)
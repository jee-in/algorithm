package ch05_Recursive;

import ch04_StackAndQueue.part1_stack.InStack;

class c05_UsingStack {
    
    // 재귀 호출을 사용하지 않고 비재귀적으로 구현하는 방법(2)
    // - 변수 n의 값을 스택에 저장하기

    static void recur(int n) {
        InStack s = new InStack(n);

        while (true) {
            if (n > 0) {
                s.push(n);
                n = n - 1;
                continue;
            }

            if (s.isEmpty() != true) {
                n = s.pop();
                System.out.println(n);
                n = n -2;
                continue; // 메서드의 처음으로 돌아감
            }
        break;
        }
    }
}

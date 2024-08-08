package ch05_Recursive;

import java.util.Scanner;

// 메모화(memoization) 기법을 사용하여 동일한 계산을 반복하지 않고 1회만 수행

class c06_RecurMemo {
    
    static String[] memo;
    static int count = 0;

    static void recur(int n) {

        count++;

        if (memo[n + 1] != null) {
            System.out.print(memo[n + 1]); 
        } else {
            if (n > 0) {
                recur(n - 1); 
                System.out.println(n);
                recur(n - 2);
                memo[n + 1] = memo[n] + n + "\n" + memo[n-1];
            } else {
                memo[n + 1] = "";
            }
        }

        // n이 0이거나 0보다 작을 때
        // recur(-1) -> memo[0]: ""
        // recur(0) -> memo[1]: ""

        // n이 0보다 클 때
        // recur(1) -> memo[2]: "" + 1 + "\n" + ""
        // recur(2) -> memo[3]: 1 + "\n" + 2 + "\n" + ""
        // recur(3) -> memo[4]: 1 + "\n" + 2 + "\n" + 3 + "\n" + 1 + "\n"
        // ...

    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int x = stdIn.nextInt();

        memo = new String[x + 2]; // memo[0]과 memo[1]은 각각 recur(-1)과 recur(0)을 위한 공간
        recur(x);
        System.out.println("recur 메서드를 호출한 횟수: " + count);
    }
}

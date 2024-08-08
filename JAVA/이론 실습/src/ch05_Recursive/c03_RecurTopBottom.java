package ch05_Recursive;

import java.util.Scanner;

class c03_RecurTopBottom {

    static int count = 0;
    
    // 순수(genuinely) 재귀: 재귀 호출을 여러 번 실행하는 메서드
    static void recursive(int n) {

        count++;

        if (n > 0) {
            recursive(n - 1);
            System.out.println(n);
            recursive(n - 2);
        }
    }

    // 하향식 분석(top-down analysis)의 예시
    // - recursive(4)의 출력 값: 
    // recursive(3) / 4 / recursive(2)
    // recursive(2) / 3 / recursive(1) / 4 / recursive(0) / 2 / recursive(1)
    // ...
    // top에서부터 분석하다 보면 같은 메서드를 여러 번 호출하게 되어 비효율적임

    // 상향식 분석(bottom-ip analysis)
    // recursive(1)의 출력 값: 1
    // recursive(2)의 출력 값: 1 / 2
    // recursive(3)의 출력 값: 1 / 2 / 3 / 1
    // recursive(4)의 출력 값: 1 / 2 / 3 / 1 / 4 / 1 / 2
    // ...

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요: ");
        int x = stdIn.nextInt();

        recursive(x);
        System.out.println("recur 메서드를 호출한 횟수: " + count);
    }
}

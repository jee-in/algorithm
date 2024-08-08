package ch05_Recursive;

import java.util.Scanner;

class c01_Factorial {

    static int factorial(int n) {
        if (n > 0) return n * factorial(n-1);
        else return 1; // 0! = 1
        // 삼항 연산자 이용 시 다음과 같이 한 줄로도 작성 가능
        // return (n > 0)? n * factorial(n-1) : 1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요.: ");
        int x = stdIn.nextInt();

        System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
    }
}

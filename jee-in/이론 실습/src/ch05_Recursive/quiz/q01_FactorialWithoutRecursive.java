package ch05_Recursive.quiz;
/*********************************************************
 * q01. factorial 메서드를 재귀 메서드 호출을 사용하지 말고 작성해보기
*********************************************************/

import java.util.Scanner;

class q01_FactorialWithoutRecursive {

    static int factorial(int num) {

        int result = 1;
        for (int i = num; i >= 1; i--) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요: ");
        int num = stdIn.nextInt();

        System.out.println(num + "의 팩토리얼 값은 " + factorial(num) + "입니다.");
    }
    
}

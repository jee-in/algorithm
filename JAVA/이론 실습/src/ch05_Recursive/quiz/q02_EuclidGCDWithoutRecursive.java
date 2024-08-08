package ch05_Recursive.quiz;

/*********************************************************
 * q02. EuclidGCD 메서드를 재귀 메서드 호출을 사용하지 말고 작성해보기
*********************************************************/

import java.util.Scanner;

public class q02_EuclidGCDWithoutRecursive {

    static int EuclidGCD(int x, int y) {

        while(y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }

        return x;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수 1을 입력하세요: ");
        int x = stdIn.nextInt();

        System.out.print("정수 2를 입력하세요: ");
        int y = stdIn.nextInt();

        System.out.println(x + "와 " + y + "의 최대공약수는 " + EuclidGCD(x, y) + "입니다.");
    }

}

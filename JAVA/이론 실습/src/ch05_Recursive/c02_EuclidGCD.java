package ch05_Recursive;

import java.util.Scanner;

class c02_EuclidGCD {

    // 정수 x, y의 최대공약수를 구하여 반환
    static int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x % y);

        // 유클리드 호제법
        // : 두 수 x(큰 수)와 y(작은 수)가 있을 때, x는 y 또는 y의 배수보다 클 것이다.
        // : x에서 y 또는 y의 배수만큼 빼고 남은 나머지가 있다고 하자.
        // : 이 나머지와 y(작은 수)의 최대공약수가 곧 최대공약수가 됨을 알 수 있다.
        // : 이러한 논리는 재귀적으로 수행될 수 있다. 재귀 수행은 나머지가 y로 나누어질 때 종료된다.
        
        // step1: 첫 번째 gcd를 수행. <예시> gcd(22, 8) --반환--> gcd(8, 6) 큰 수 x에서 작은 수(또는 작은 수의 배수)를 뺀 나머지를 구한다.
        // step2: 두 번째 gcd를 수행. <예시> gcd(8, 6) --반환--> gcd(6, 2) 작은 수 y에서 나머지(또는 나머지의 배수)를 뺀 나머지2를 구한다.
        // step3: 세 번째 gcd를 수행. <예시> gcd(6, 2) --반환--> gcd(2, 0)
        // step4: 네 번째 gcd를 수행. <예시> gcd(2, 0) --반환--> 2

        // *만약 y 자리에 더 큰 수가 들어갔다면?
        // step1: 첫 번째 gcd를 수행. <예시> gcd(8, 22) --반환--> gcd(22, 8)
        // 위와 같이 첫 번째 gcd를 수행하면 x와 y 중 더 큰 수가 x 자리로 가게 된다.
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("두 정수의 최대공약수를 구합니다.");

        System.out.print("정수를 입력하세요: "); int x = stdIn.nextInt();
        System.out.print("정수를 입력하세요: "); int y = stdIn.nextInt();

        System.out.println("최대공약수는 " + gcd(x, y) + "입니다.");
    }

}
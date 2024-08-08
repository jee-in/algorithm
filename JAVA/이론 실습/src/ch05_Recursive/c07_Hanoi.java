package ch05_Recursive;

import java.util.Scanner;

class c07_Hanoi {
    
    static void move(int no, int current, int target) {
        if (no > 1) 
            move(no - 1, current, 6 - current - target); // 기둥 1, 2, 3의 합이 6임을 이용

        System.out.printf("원반[%d]을(를) %d번 기둥에서 %d번 기둥으로 옮김\n", no, current, target);

        if (no > 1) 
            move(no - 1, 6 - current - target, target);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반의 개수: ");
        int n = stdIn.nextInt();

        move(n, 1, 3);
    }
}

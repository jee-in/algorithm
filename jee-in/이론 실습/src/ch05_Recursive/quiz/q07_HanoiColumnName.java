package ch05_Recursive.quiz;

import java.util.Scanner;

public class q07_HanoiColumnName {

    static String[] columns = {"", "A", "B", "C"};

    static void move(int no, int start, int target) {

        if (no > 1) {
            move(no-1, start, 6 - start - target);
        }

        System.out.printf("원반[%d]을/를 %s 기둥에서 %s 기둥(으)로 옮깁니다.\n", no, columns[start], columns[target]);

        if (no > 1) {
            move(no-1, 6 - start - target, target);
        }
    }
 
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반의 개수: ");
        int n = stdIn.nextInt();
        
        move(n, 1, 3);

    }

}

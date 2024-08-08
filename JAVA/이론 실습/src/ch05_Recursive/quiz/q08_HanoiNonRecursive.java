package ch05_Recursive.quiz;

import java.util.Scanner;
import ch04_StackAndQueue.part1_stack.InStack;

public class q08_HanoiNonRecursive {
    
    static void move(int no, int start, int target) {
        
        InStack stack = new InStack(no);
        int temp = 0;

        while (true) {

            if (no > 1) {
                stack.push(no - 1);
                continue;
            }

            if (stack.isEmpty() != true) {
                n = stack.pop();
                System.out.printf("원반[%d]을/를 %s 기둥에서 %s 기둥(으)로 옮깁니다.\n", no, start, target);

                start = temp;
                start = 6 - start - target;
                target = temp;

                continue;
            }

        }


        while (no > 1) {
            move(no -1, start, 6 - start - target);

            start = temp;
            start = 6 - start - target;
            target = temp;
            continue;
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

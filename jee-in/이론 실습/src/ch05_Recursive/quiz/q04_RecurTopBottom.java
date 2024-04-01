package ch05_Recursive.quiz;

/*********************************************************
 * q04. 재귀 메서드 하향식, 상향식 분석하기
*********************************************************/

public class q04_RecurTopBottom {

    static void recursive2(int n) {
        if (n > 0) {
            recursive2(n-2);
            System.out.println(n);
            recursive2(n-1);
        }
    }

    // 하향식 분석
    // recursive2(5)의 출력 값:
    // recursive2(3) / 5 / recursive2(4)
    // recursive2(1) / 3 / recursive2(2) / 5 / recursive2(2) / 4 / recursive2(3)
    // 1 / 3 / 2 / 1 / 5 / 2 / 1 / 4 / 1 / 3 / 2 / 1
    
    // 상향식 분석
    // recursive2(1)의 출력 값: 1
    // recursive2(2)의 출력 값: 2 / 1
    // recursive2(3)의 출력 값: 1 / 3 / 2 / 1
    // recursive2(4)의 출력 값: 2 / 1 / 4 / 1 / 3 / 2 / 1
    // recursive2(5)의 출력 값: 1 / 3 / 2 / 1 / 5 / 2 / 1 / 4 / 1 / 3 / 2 / 1 
}

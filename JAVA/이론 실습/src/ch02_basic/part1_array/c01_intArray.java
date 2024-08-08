package ch02_basic.part1_array;

/***************************************************
 * 숫자 배열 기초
 ****************************************************/

public class c01_intArray {
    public static void main(String[] args) {
        /*
         * (1) new 연산자로 배열 생성
         * - 배열의 구성 요소가 자동으로 0으로 초기화됨
         */
        int[] a = new int[5];

        a[1] = 30;
        a[2] = 50;
        a[4] = a[2] * 2;

        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }

        /*
         * (2)배열 초기화에서 생성
         * - 배열 생성과 동시에 구성 요소의 값을 초기화할 수 있음
         */

        int[] b = { 1, 2, 3, 4, 5 };

        for (int i = 0; i < b.length; i++) {
            System.out.println("b[" + i + "] = " + b[i]);
        }

    }
}

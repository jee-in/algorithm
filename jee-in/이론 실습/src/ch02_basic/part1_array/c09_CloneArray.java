package ch02_basic.part1_array;

/********************************************
 * 배열 복사하기 
 * - clone()
 ******************************************/

import java.util.Arrays;

public class c09_CloneArray {
  public static void main(String[] args) {
    int[] a = { 1, 2, 3, 4, 5 }; // 빈 배열을 생성한 경우 배열에 접근할 때
                                 // IndexOutOfBoundsException이 발생함
    int[] b = a.clone(); // 배열 복사

    b[3] = 0;

    System.out.println("a = " + Arrays.toString(a));
    System.out.println("a = " + Arrays.toString(b));
  }
}

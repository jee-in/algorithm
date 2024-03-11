package ch02_basic.quiz;

/********************************************************************
 * Q4-5. 배열 b의 모든 요소를 (역순으로) a에 복사하기
 ****************************************************************** */

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class q04_05_CopyOfArray {

  static void copy(int[] a, int[] b) {
    // // 그대로 복사
    // for (int i = 0; i < b.length; i++) {
    // a[i] = b[i];
    // }

    // 역순으로 복사
    for (int i = 0; i < b.length; i++) {
      a[i] = b[b.length - i - 1];
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    System.out.print("배열의 길이: ");
    int num = sc.nextInt();

    int[] b = new int[num];

    for (int i = 0; i < b.length; i++) {
      b[i] = rand.nextInt(10);
    }
    System.out.println("배열 b: " + Arrays.toString(b));

    int[] a = new int[num];
    copy(a, b);

    System.out.println("배열 a: " + Arrays.toString(a));

  }

}

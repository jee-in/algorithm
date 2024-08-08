package ch02_basic.quiz;

/********************************************************************
 * Q3. 배열의 모든 요소의 합계 구하기
 ****************************************************************** */

import java.util.Random;
import java.util.Arrays;

public class q03_SumOfArray {

  static int sumOf(int[] a) {
    int sum = 0;
    for (int i = 0; i < a.length; i++)
      sum += a[i];
    return sum;
  }

  public static void main(String[] args) {

    Random rand = new Random();

    int num = 1 + rand.nextInt(11); // 배열의 길이 난수 생성
    System.out.println("배열의 길이: " + num);

    int[] arr = new int[num];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = rand.nextInt(10); // 배열의 요소 난수 생성
      System.out.println("arr[" + i + "]: " + arr[i]);
    }
    System.out.println("배열 arr: " + Arrays.toString(arr));

    // 배열의 모든 요소를 더하기
    int sum = sumOf(arr);
    System.out.println("배열 arr 모든 요소의 합: " + sum);
  }
}

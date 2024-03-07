package ch02_BasicDataStructure.ch02_1_Array.Quiz;

/********************************************************************
 * Q1. 랜덤한 크기의 배열에 랜덤한 값을 넣고 배열의 최댓값 구하기
 ****************************************************************** */

import java.util.Random;

public class q01_MaxOfRandomRangeArray {

  // 배열의 최댓값을 구하는 메서드
  static int maxOf(int[] a) {
    int max = a[0];
    for (int i = 1; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Random rand = new Random();

    System.out.println("배열의 최댓값을 구합니다.");

    // 배열의 길이를 난수로 생성하기
    int num = 5 + rand.nextInt(11); // 5 ~ 15 사이의 난수

    System.out.println("배열의 길이: " + num);

    // 배열의 길이만큼 배열 생성하기
    int[] arr = new int[num];

    System.out.println("배열의 요소를 난수로 생성하겠습니다.");
    for (int i = 0; i < arr.length; i++) {
      arr[i] = rand.nextInt(101); // 변수 rand에 대하여 nextInt(n) 메서드는 0부터 (n-1)까지의 난수를 생성함
      System.out.println("arr[" + i + "]: " + arr[i]);
    }

    System.out.println("배열의 최댓값은 " + maxOf(arr) + "입니다.");
  }

}

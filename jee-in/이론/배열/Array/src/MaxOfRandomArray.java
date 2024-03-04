// 랜덤한 숫자를 가지는 배열의 최댓값 구하기

import java.util.Random;
import java.util.Scanner;

public class MaxOfRandomArray {

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
    Scanner sc = new Scanner(System.in);

    System.out.println("배열의 최댓값을 구합니다.");

    // (1) 배열의 길이를 입력받기
    // int num = sc.nextInt();
    // (2) 배열의 길이를 난수로 생성하기
    int num = rand.nextInt(10);
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

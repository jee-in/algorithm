
/********************************************
 * 배열에서 최댓값 출력
 ****************************************** */

import java.util.Scanner;

public class c02_MaxOfArray {

  // 배열 a의 최댓값을 구하여 반환하는 메서드
  static int maxOf(int[] a) { // 매개변수 a의 자리에는 참조 변수가 오게 되어, a는 배열 본체를 참조하게 됨

    // 배열의 첫 번째 요소를 최댓값으로 설정
    int max = a[0];

    // 배열의 두 번째 요소부터 마지막 요소까지 값을 확인하며 최댓값을 재설정
    for (int i = 1; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("배열의 최댓값을 구합니다.");
    System.out.print("배열 길이: ");
    int num = sc.nextInt(); // 배열의 길이를 입력받고, 정수형으로 변환

    int[] arr = new int[num];

    for (int i = 0; i < arr.length; i++) {
      System.out.print("arr[" + i + "]: ");
      arr[i] = sc.nextInt();
    }

    System.out.println("배열의 최댓값은 " + maxOf(arr) + "입니다.");
  }

}

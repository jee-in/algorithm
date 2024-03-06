// 배열을 역순으로 정렬하기

import java.util.Arrays; // toString() 메서드 보유
import java.util.Scanner;

public class ReverseArray {

  // swap 메서드: 배열 a의 idx1번째 요소와 idx2번째 요소의 값을 교환함
  static void swap(int[] a, int idx1, int idx2) {
    System.out.println("a[" + idx1 + "]와 a[" + idx2 + "]를 교환합니다.");
    int temp = a[idx1];
    a[idx1] = a[idx2];
    a[idx2] = temp;
    System.out.println(Arrays.toString(a));
  }

  // reverse 메서드: 배열의 양 끝끼리 swap함 *배열의 길이가 홀수일 경우, 가운데 요소는 그대로 유지함
  static void reverse(int[] a) {
    for (int i = 0; i < a.length / 2; i++) {
      swap(a, i, a.length - i - 1);
    }
    System.out.println("역순 정렬을 마쳤습니다.");
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("배열의 길이: ");
    int num = sc.nextInt(); // 배열의 길이를 입력받고, 정수로 변환

    int[] x = new int[num]; // 배열의 길이가 num인 배열

    for (int i = 0; i < num; i++) {
      System.out.print("x[" + i + "]: ");
      x[i] = sc.nextInt();
    }

    // 배열 x를 역순으로 정렬
    reverse(x);

    // System.out.println("요소를 역순으로 정렬했습니다.");
    // Arrays의 toString() 메서드는 모든 요소를 쉼표로 구분하여, []로 둘러싼 문자열을 반환해 줌
    // System.out.println("x = " + Arrays.toString(x)); // 참조 변수 x에는 배열의 주소가 들어 있음
  }

}

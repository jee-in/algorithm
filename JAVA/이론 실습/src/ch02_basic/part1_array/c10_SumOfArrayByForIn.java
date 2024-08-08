package ch02_basic.part1_array;

/********************************************
 * 확장 for문 (for-in문 또는 for-each문)
 ******************************************/

public class c10_SumOfArrayByForIn {
  public static void main(String[] args) {
    double[] a = { 1.0, 2.0, 3.0, 4.0, 5.0 };
    double sum = 0;

    // 일반 for문
    // for (int i = 0; i < a.length; i++)
    // sum += a[i];

    // 확장 for문
    for (double i : a) // 배열 a 안에 있는 요소 i 그 자체
      sum += i;

    // 장점
    // (1) 배열의 길이를 조사하지 않아도 된다.
    // (2) 배열의 모든 요소를 누락하지 않고 스캔할 수 있다. (실수 방지 가능)
    // (3) iterator와 같은 방법으로 스캔할 수 있다.

    System.out.println("모든 요소의 합은 " + sum + "입니다.");
  }
}

package ch02_basic.quiz;

/********************************************
 * Q7. 10진수의 정수를 2~36진수로 변환하는 과정을 자세히 나타내기
 ****************************************** */

import java.util.Scanner;

class q06_RadixConversionVisual {

  static int conversion(int num, int radix, char[] d) { // 정수 num을 radix(2~36진수)로 변환하여 문자 배열인 d로 반환하는 메서드

    int index = 0; // 문자 배열 d의 자릿수를 왼쪽부터 세는 인덱스
    String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 문자 배열 d에 변환한 수를 넣을 때 문자열 dchar에서 가져다 씀

    // 계산 시각화 (1)
    System.out.println(String.format("%2d", radix) + "|" + String.format("%10d", num));

    // 정수 num을 radix로 무조건 한 번은 나눔. 몫이 1보다 같거나 크다면 나눗셈을 반복함.
    do {
      // 계산 수행
      d[index++] = dchar.charAt(num % radix); // num을 radix로 나눈 나머지를 문자 배열 d에 왼쪽부터 차례대로 삽입함.
      num /= radix; // 다음 계산을 위해 num을 radix로 나눈 몫으로 갱신함. 이때 num이 radix보다 작아지면 반복문을 탈출함.

      // 계산 시각화 (2)
      System.out.println(String.format("%3s", "+ ") + "----------");
      /*
       * - repeat()는 자바 11부터 지원
       * System.out.println(String.format("%3s","+ ") + "-".repeat(10));
       */

      if (num != 0) { // 마지막 줄이 아닐 때
        System.out.print(String.format("%2d", radix) + "|" + String.format("%10d", num));
      } else { // 마지막 줄일 때
        System.out.print(String.format("%13d", num));
      }
      System.out.println(" ... " + d[index - 1]);
    } while (num != 0);

    // 문자 배열 d의 요소를 역순으로 정렬
    for (int i = 0; i < index / 2; i++) { // 변환된 수의 길이는 마지막 요소의 인덱스에 1을 더한 값이므로 변수 index을 이용하면 됨
      char temp = d[i];
      d[i] = d[index - i - 1];
      d[index - i - 1] = temp;
    }

    return index;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int num; // souce에 해당하는 정수
    int radix; // target에 해당하는 진법
    int digits; // target의 전체 자릿수(길이)
    int retry; // 프로그램 재실행 여부
    char[] result = new char[32]; // target을 담을 문자 배열. 넉넉하게 32자리로 생성됨.

    System.out.println("############################## 진수 변환 프로그램 ##############################");
    do {
      // source에 해당하는 num에 0 또는 양수가 들어올 때까지 입력받기
      do {
        System.out.print("어떤 수를 변환할까요? (음이 아닌 정수): ");
        num = sc.nextInt();
      } while (num < 0);

      // target에 해당하는 진법에 2 이상 36 이하가 들어올 때까지 입력받기
      do {
        System.out.print("어떤 진수로 변환할까요? (2 이상 36 이하): ");
        radix = sc.nextInt();
      } while (radix < 2 || radix > 36);

      // 정수 num을 radix에 해당하는 진수로 변환했을 때 변환된 숫자의 길이
      digits = conversion(num, radix, result); // conversionrk 수행되면 문자 배열 result에는 변환된 수가 담김

      // 문자 배열 result에 담겨 있는 변환된 숫자들을 하나씩 출력
      System.out.print("변환 결과: ");
      for (int i = 0; i < digits; i++) {
        System.out.print(result[i]);
      }
      System.out.println("");

      // 프로그램 재실행 여부
      // 1 또는 0이 들어올 때까지 입력받기
      do {
        System.out.print("변환을 계속하시겠습니까? (1...예/ 0...아니오): ");
        retry = sc.nextInt();
      } while (retry != 1 && retry != 0);
    } while (retry == 1);
  }
}

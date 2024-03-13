package ch03_searching.quiz;

/***************************************************
 * Q2. 선형 검색의 과정 시각화하기
 ****************************************************/

import java.util.Scanner;
import java.util.Random;

public class q02_seqSearchVisual {

  static int SeqSearchVisual(int[] x, int num, int key) {

    int index = 0;

    // 시각화를 위한 준비
    String blank = "   ";
    String hypen = "---";
    String firstLine = blank + "|" + "  "; // 첫 줄
    String secondLine = hypen + "+" + hypen; // 두 번째 줄
    String emptyLine = blank + "|" + "  "; // 빈 줄
    String[] signLine = new String[num]; // 검색 표시 줄
    String[] arrayLine = new String[num]; // 배열 요소 줄

    for (int i = 0; i < num; i++) {
        firstLine += (i + blank);
        secondLine += ("-" + hypen);
        emptyLine += (" " + blank);
        signLine[i] = (blank + "|" + "  ");
        arrayLine[i] = ("  " + i + "|" + "  ");

        for (int j = 0; j <num; j++) {
          arrayLine[i] += (x[j] + blank);

          if (i == j) {
            signLine[i] += ("*" + blank);
          } else {
            signLine[i] += (" " + blank);
          }
        }
    }

    // 처음 두 줄 출력
    System.out.println(firstLine);
    System.out.println(secondLine);

    // 선형 검색을 진행하면서 그 과정도 같이 출력
    for (int i = 0; i < num; i++) {
      index = i;

      System.out.println(signLine[index]);
      System.out.println(arrayLine[index]);
      System.out.println(emptyLine);

      if (x[index] == key) break;
    }
    return (index == num)? -1 : index;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    // 배열 생성하기
    System.out.print("배열의 길이: ");
    int num = sc.nextInt();
    int[] x = new int[num + 1];

    for (int i = 0; i < num; i++) {
      x[i] = rand.nextInt(10);
      System.out.println("x[" + i + "]: " + x[i]);
    }

    // 찾을 값 입력받기
    System.out.print("찾을 값: ");
    int key = sc.nextInt();
    x[num] = key;

    int result = SeqSearchVisual(x, num, key);

    if (result == -1) System.out.println("배열에 찾는 값이 없습니다.");
    else System.out.println("찾는 값은 x[" + result + "]에 있습니다.");
  }
}

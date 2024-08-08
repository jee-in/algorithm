package ch03_searching.quiz;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/***************************************************
 * Q3. 배열에서 key와 일치하는 모든 요소의 인덱스 반환하기
 ****************************************************/

public class q03_SearchAll {
  
  static int[] SearchAll(int[] x, int num, int key, int[] idx) {

    int index = 0; // 배열 x를 위한 인덱스 카운터
    int count = 0; // 배열 idx를 위한 인덱스 카운터
    int[] temp = new int[num];
    
    for (int i = 0; i < num; i++) {
      index = i;
      if (x[index] == key) {
        temp[count] = index;
        count++;
      };
    }

    idx = new int[count];

    for (int i = 0; i < count; i++) {
      idx[i] = temp[i];
    }
    
    return idx;
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

    // key와 일치하는 모든 요소의 인덱스를 반환받을 배열
    int[] idx = new int[num];

    idx = SearchAll(x, num, key, idx);

    System.out.print("찾는 값이 있는 인덱스의 배열: ");
    System.out.print(Arrays.toString(idx));
    System.out.println("");
    System.out.println("배열 idx의 길이: " + idx.length);
  }
}

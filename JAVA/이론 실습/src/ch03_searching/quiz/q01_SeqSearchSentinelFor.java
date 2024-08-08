package ch03_searching.quiz;

/***************************************************
 * Q1. 보초법(sentinel)으로 선형 검색을 while문이 아닌 for문으로 구현해보기
 * - 선형 검색에서 종료 조건을 검사하는 비용을 반으로 줄이는 방법
 ****************************************************/

import java.util.Scanner;
import java.util.Random;

public class q01_SeqSearchSentinelFor {

  static int SeqSearch(int[] x, int num, int key) {

    int index = 0;
    for (int i = 0; i <= num; i++) {
      index = i;
      if (x[index] == key) break;
    }

    return (index == num)? -1 : index;
  }
  
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
  
    // 입력받은 배열의 길이만큼 난수로 정수 배열 생성
    System.out.print("배열의 길이: ");
    int num = sc.nextInt();
    int[] x = new int[num+1]; // 보초법을 위해 입력받은 수보다 1 큰 배열 생성
  
    for (int i = 0; i < num; i++) {
      x[i] = rand.nextInt(101);
      System.out.println("x[" + i + "]: " + x[i]);
    }
  
    // 찾을 값 입력받기
    System.out.print("찾을 값: ");
    int key = sc.nextInt();
    x[num] = key; // 보초법
  
    // 보초법으로 선형 검색 진행
    int result = SeqSearch(x, num, key);
    
    if (result == -1) System.out.println("배열에 찾는 값이 없습니다.");
    else System.out.println("찾는 값은 x[" + result + "]에 있습니다.");

  }



}

package ch03_searching.part2_binary;

/************************************************************
 * 이진 검색
 * - 전제 조건: 배열의 요소들이 오름차순 또는 내림차순으로 정렬되어 있어야 함
 ************************************************************/

import java.util.Scanner;

class c01_BinarySearch {

  static int binarySearch(int[] a, int n, int key) {
    int pl = 0; // 검색 시작 인덱스
    int pr = n-1; // 검색 마지막 인덱스

    do {
      int pc = (pl + pr) / 2; // 이진 검색을 위한 중앙 인덱스
      if (a[pc] == key) return pc; // 찾는 값이 중앙 인덱스의 요소와 같다면 해당 인덱스를 반환
      else if (a[pc] < key) pl = pc+1; // 찾는 값이 중앙 인덱스의 요소보다 크다면 우측에서 재검색 수행
      else pr = pc -1; // 찾는 값이 중앙 인덱스의 요소보다 작다면 좌측에서 재검색 수행
    } while (pl <= pr); // 검색 시작 인덱스가 검색 마지막 인덱스보다 같거나 작을 때까지 재검색 수행
    
    return -1; // 검색 실패 시 -1 반환
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("배열의 길이를 입력하세요: ");
    int num = sc.nextInt();
    int[] x = new int[num]; // 입력받은 길이만큼 정수 배열 생성

    System.out.println("오름차순으로 입력하세요.");

    System.out.print("x[0]: ");
    x[0] = sc.nextInt(); // 첫 번째 요소 입력받기

    for (int i = 1; i < num; i++) {
      do {
        System.out.print("x[" + i + "]: ");
        x[i] = sc.nextInt(); 
      } while (x[i] < x[i-1]); // 오름차순으로 입력되지 않을 경우 재입력받기
    }

    System.out.print("검색할 값: ");
    int key = sc.nextInt(); // 찾을 값 입력
    int index = binarySearch(x, num, key); // 이진 검색을 수행 -> 찾는 값이 있는 인덱스를 반환받음

    if (index == -1) System.out.println("그 값의 요소가 없습니다.");
    else System.out.println("그 값은 x[" + index + "]에 있습니다.");
  }
}
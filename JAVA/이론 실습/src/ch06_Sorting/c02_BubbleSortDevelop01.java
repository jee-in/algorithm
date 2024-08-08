package ch06_Sorting;

/*************************************************
 * 버블 정렬 (bubble sort) 알고리즘 개선 (1)
 ****************************************************/

public class c02_BubbleSortDevelop01{

  // swap 메서드
  static void swap(int[] arr, int index1, int index2) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  // 앞에서부터 오름차순으로 정렬
  static void bubbleSort(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < (n - 1); i++) {
      int count = 0; // i번째 회차에서 버블 정렬이 수행된 횟수를 집계하는 카운터
      for (int j = 0; j < (n - 1) - i; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
          count++;
        }
      }
    
      // 알고리즘 개선: 정렬이 완료되어 스와핑이 더 이상 발생하지 않으면 반복문 조기 종료
      if (count == 0) {
        System.out.println((i) + "번째 회차에서 반복문을 조기 종료합니다.");
        break;
      }

    // 공통 코드: 중간 결과 출력
      System.out.println("버블 정렬 " + (i + 1) + "회차 정렬");
      for (int a : arr)
        System.out.printf("%2d", a);
      System.out.println();
    }
  }
  
  
  public static void main(String[] args) {
    // 테스트 배열
    int arr[] = {7, 4, 8, 6, 1, 5, 3, 9, 2};

    // 버블 정렬 실시
    bubbleSort(arr);
  }
}
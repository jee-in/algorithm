package ch06_Sorting;

/*************************************************
 * 버블 정렬 (bubble sort) 알고리즘 개선 (2)
 * - 이미 정렬이 완료된 쪽은 정렬 범위에서 제외하기
 ****************************************************/

public class c03_BubbleSortDevelop02{

  // swap 메서드
  static void swap(int[] arr, int index1, int index2) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  // 앞에서부터 오름차순으로 정렬
  static void bubbleSort(int[] arr) {
    int n = arr.length;
    int no = 0; // 몇 회차 반복인지 표시하는 카운터
    int k = (n - 1); // 버블 정렬이 완료된 부분을 표시하기 위한 인덱스
    
    while (k > 1) {
      no++;
      int lastIdx = 0; // if문을 타지 않을 경우, k를 0으로 만들어서 while문 종료
      for (int j = 0; j < k; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
          lastIdx = j;
        }
      }
      k = lastIdx;
      
      if (k == 0) {
        System.out.println("버블 정렬을 " + (no - 1) + "회차에서 조기 종료합니다.");
        break;
      }
    
    // 공통 코드: 중간 결과 출력
      System.out.println("버블 정렬 " + no + "회차");
      for (int a : arr)
        System.out.printf("%2d", a);
      System.out.println();
    }
  }
  
  public static void main(String[] args) {
    // 테스트 배열
    int arr[] = {1, 2, 3, 7, 4, 8, 6, 5, 9};

    // 버블 정렬 실시
    bubbleSort(arr);
  }
}
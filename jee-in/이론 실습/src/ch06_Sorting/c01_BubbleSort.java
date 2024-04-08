package ch06_Sorting;

/*************************************************
 * 버블 정렬 (bubble sort)
 * - 이웃한 두 요소의 대소 관계를 비교하고 필요에 따라 교환을 반복하는 알고리즘
 * - 단순 교환 정렬 (straight exchange sort)라고도 함
 ****************************************************/

public class c01_BubbleSort{

  // swap 메서드
  static void swap(int[] arr, int index1, int index2) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  static void bubbleSort(int[] arr) {
    int n = arr.length;

    // 01-1. 앞에서부터 오름차순으로 정렬
    for (int i = 0; i < (n - 1); i++) {
      for (int j = 0; j < (n - 1) - i; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
        }
      }
    
    // 01-2. 앞에서부터 내림차순으로 정렬
    /*
    for (int i = 0; i < (n - 1); i++) {
      for (int j = 0; j < (n - 1) - i; j++) {
        if (arr[j] < arr[j + 1]) {
          swap(arr, j, j + 1);
        }
    }
    */

    // 02-1. 뒤에서부터 오름차순으로 정렬
    /*
    for (int i = 0; i < (n - 1); i++) {
      for (int j = (n - 1); j > i; j--) {
        if (arr[j - 1] > arr[j]) {
          swap(arr, j - 1, j);
        }
    }
    */

    // 02-2. 뒤에서부터 내림차순으로 정렬
    /* 
    for (int i = 0; i < (n - 1); i++) {
      for (int j = (n - 1); j > i; j--) {
        if (arr[j - 1] < arr[j]) {
          swap(arr, j - 1, j);
        }
    }
    */

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
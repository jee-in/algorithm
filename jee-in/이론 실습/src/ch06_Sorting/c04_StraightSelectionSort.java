package ch06_Sorting;

/*************************************************
 * 단순 선택 정렬(straight selection sort)
 * - 가장 작은 요소(min) 또는 가장 큰 요소(max)를 맨 앞 또는 맨 뒤로 위치시키기
 * - 안정된 정렬은 아님. 중복된 숫자가 있을 경우 두 수의 원래 순서가 보장되지 않음.
 ****************************************************/

public class c04_StraightSelectionSort {

  // swap 메서드
  static void swap(int[] arr, int index1, int index2) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  // 오름차순 정렬
  static void straightSelectionSort(int[] arr) {
    
    for (int i = 0; i < (arr.length - 1); i++) {
      int minIdx = i;
      for (int j = (i + 1); j < arr.length; j++) {
        if (arr[j] < arr[minIdx]) {
          minIdx = j;
        }        
      }
      swap(arr, i, minIdx);
      
      // 선택 정렬 중간 결과 출력
      System.out.println((i+1) + "회차: " + "arr[" + i + "] 결정 완료");
      for (int a : arr) {
        System.out.printf("%2d", a);
      }
      System.out.println();
    }
  }


  public static void main(String[] args) {

    int[] arr = {6, 4, 8, 1, 9, 2, 3, 7, 5};
    straightSelectionSort(arr);
  }

}

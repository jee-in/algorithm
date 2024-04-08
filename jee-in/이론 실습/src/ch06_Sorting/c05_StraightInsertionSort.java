package ch06_Sorting;

/*************************************************
 * 단순 삽입 정렬(straight insertion sort)
 ****************************************************/

public class c05_StraightInsertionSort {

  static void straightInsertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      int j;
      int temp = arr[i];
      for (j = i; j > 0 && arr[j - 1] > temp; j--) // 삽입 정렬하려는 숫자보다 큰 수가 나오면
        arr[j] = arr[j - 1]; // 그 수를 오른쪽으로 한 칸 이동시켜서 삽입할 수 있는 자리 만들기
      arr[j] = temp; // 삽입 정렬하려는 숫자보다 작은 수가 나오면 그 자리의 오른쪽에 숫자 삽입하기
    
      System.out.println(i + "번째 정렬");
      for (int a : arr)
        System.out.printf("%2d", a);
      System.out.println();
    }
  }

  public static void main(String[] args) {

    int[] arr = {6, 4, 8, 1, 9, 2, 3, 7, 5};
    straightInsertionSort(arr);
  }
}

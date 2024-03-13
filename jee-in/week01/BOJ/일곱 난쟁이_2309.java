import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int dwarfs[] = new int[9];
    int sum = 0;
    int[] result = new int[7]; // 정답을 담을 배열
    int count = 0; // 정답을 담을 배열 result의 index

    // 아홉 난쟁이의 키를 배열에 입력받기
    for (int i = 0; i < 9; i++) {
      dwarfs[i] = sc.nextInt();
      sum += dwarfs[i];
    }

    // 두 난쟁의 키의 합이 sum-100이 나오면
    // 두 난쟁이의 키를 뺀 나머지 난쟁이의 키를 result 배열에 담아 출력

    int two = 0;

    for (int i = 0; i < (9 - 1); i++) {
      for (int j = (i + 1); j < 9; j++) {
        two = dwarfs[i] + dwarfs[j];

        if (sum - two == 100) {
          // result 배열에 두 난쟁이를 뺀 나머지 난쟁이만 담음
          for (int k = 0; k < 9; k++) {
            if (k == i || k == j)
              continue;
            else {
              result[count] = dwarfs[k];
              count++;
            }
          }

          // result 배열 오름차순 정렬
          int min = 0;
          int temp = 0;
          for (int p = 0; p < (7 - 1); p++) {
            min = result[p];
            for (int q = p; q < 7; q++) {
              if (result[q] < min) {
                min = result[q];
                temp = result[p];
                result[p] = result[q];
                result[q] = temp;
              }
            }
          }

          // 출력
          for (int r = 0; r < 7; r++) {
            System.out.println(result[r]);
          }
          return;
        } else
          continue;
      }
    }

  }
}
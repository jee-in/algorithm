import java.util.Scanner;

public class NQueen_9663 {
  static int rows; // 열 및 행의 수
  static int diagonals;
  static int pos[]; // 해당 열에 배치된 퀸의 행 위치를 표시
  static boolean[] flag_a; // 해당 행에 퀸이 배치됐는지 여부를 표시
  static boolean[] flag_b; // / 방향 대각선에 퀸이 배치됐는지 여부를 표시
  static boolean[] flag_c; // \ 방향 대각선에 퀸이 배치됐는지 여부를 표시

  static int count;

    // 가능한 조합 모두 출력
  // static void print() {
  // 	for (int i = 0; i < rows; i++) {
  // 		System.out.printf("%2d", pos[i]);
  // 	}
  // 	System.out.println();
  // }

  static void set(int i) {
    for (int j = 0; j < rows; j++) {
            // 퀸은 각 행, 대각선에 하나만 배치
      if (flag_a[j] == false && flag_b[i + j] == false && flag_c[i - j + (rows-1)] == false) {
        pos[i] = j;

        if (i == (rows-1)) {     // 마지막 열까지 배치를 완료하면 경우의 수를 1 증가시킴
          count++;
        } 
        flag_a[j] = flag_b[i + j] = flag_c[i - j + (rows-1)] = true;
        set(i + 1);
        flag_a[j] = flag_b[i + j] = flag_c[i - j + (rows-1)] = false;
        
      }	
    }
  }

  public static void main(String[] args) {

    Scanner stdIn = new Scanner(System.in);
    rows = stdIn.nextInt();
    stdIn.close();
    
    pos = new int[rows];
    flag_a = new boolean[rows];
    
    diagonals = 2*rows -1;
    flag_b = new boolean[diagonals];
    flag_c = new boolean[diagonals];
    
    set(0);

    System.out.print(count);
  }
}


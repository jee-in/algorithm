import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N;
  static int K;
  static int[][] itemArray;

  public static void main(String[] args) throws IOException {
    initialize();
    System.out.println(knapsack());
  }

  static void initialize() throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String[] firstLine = bufferedReader.readLine().split(" ");
    N = Integer.parseInt(firstLine[0]);
    K = Integer.parseInt(firstLine[1]);
    itemArray = new int[N][2];

    for (int i = 0; i < N; i++) {
      String[] item = bufferedReader.readLine().split(" ");
      itemArray[i][0] = Integer.parseInt(item[0]);
      itemArray[i][1] = Integer.parseInt(item[1]);
    }

  }

  static int knapsack() {

    int[] dp = new int[K + 1];
    for (int i = 0; i < N; i++) {
      int W = itemArray[i][0];
      int V = itemArray[i][1];

      for (int j = K; j >= W; j--) {
        dp[j] = Math.max(dp[j - W] + V, dp[j]);
      }
    }

    return dp[K];
  }
}

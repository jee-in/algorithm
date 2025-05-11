import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static char[] s1;
  static char[] s2;

  public static void main(String[] args) throws IOException {
    initializeData();
    System.out.println(LCS(s1, s2));
  }

  static void initializeData() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    s1 = bufferedReader.readLine().toCharArray();
    s2 = bufferedReader.readLine().toCharArray();
  }

  static int LCS(char[] s1, char[] s2) {
    int[][] dp = new int[s1.length + 1][s2.length + 1];
    for (int i = 1; i < s1.length + 1; i++) {
      for (int j = 1; j < s2.length + 1; j++) {
        if (s1[i - 1] == s2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[s1.length][s2.length];
  }
}

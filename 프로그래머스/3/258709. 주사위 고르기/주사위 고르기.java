import java.util.*;

class Solution {

    int[][] dice;      // 입력 주사위 저장용 전역 변수
    int fullMask;      // 전체 주사위 선택 상태를 나타내는 비트마스크 (111...1)

    public int[] solution(int[][] input) {
        this.dice = input;

        int n = dice.length;
        int diceCnt = n / 2;               // A가 선택할 주사위 개수
        this.fullMask = (1 << n) - 1;      // n개의 비트를 모두 1로 채운 fullMask

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();

        // nC(n/2) 모든 조합을 비트마스킹으로 탐색
        for (int i = 0; i < (1 << n); i++) {
            if (Integer.bitCount(i) == diceCnt) {
                // i는 A의 주사위 선택 상태
                int winCount = countWins(i);  // A vs B 승리 횟수 계산
                list.add(Map.entry(i, winCount));
            }
        }

        // 승리 횟수가 가장 높은 조합 선택
        Map.Entry<Integer, Integer> bestCase = Map.entry(0, 0);
        for (Map.Entry<Integer, Integer> entry : list) {
            if (entry.getValue() > bestCase.getValue()) {
                bestCase = entry;
            }
        }

        // bestCase의 주사위 번호를 1-based 배열로 반환
        int[] answer = new int[diceCnt];
        int mask = bestCase.getKey();
        for (int i = 0, index = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                answer[index++] = i + 1;   // 1-based로 변환
            }
        }

        return answer;
    }


    // A가 선택한 주사위 마스크(mask)를 기준으로
    // A vs B의 모든 경우의 합을 비교하여 A가 이기는 경우의 수를 반환
    public int countWins(int mask) {
        int wins = 0;

        int a = mask;                   // A의 주사위 선택
        int b = ~mask & fullMask;       // B의 주사위 선택 (남은 것들)

        int[] sumsA = countSums(a);     // A가 만들 수 있는 합의 경우 수
        int[] sumsB = countSums(b);     // B가 만들 수 있는 합의 경우 수

        int sumsBLen = sumsB.length;
        int sumsALen = sumsA.length;

        // B의 합 분포 누적합 계산
        // sumsB[sum] = B가 sum 이하의 합을 가질 경우의 수
        for (int sum = 1; sum < sumsBLen; sum++) {
            sumsB[sum] += sumsB[sum - 1];
        }

        int bMax = sumsBLen - 1;

        // A의 합이 sum일 때, B가 그보다 작은 합을 가지는 모든 경우 수 * A의 해당 합 경우 수
        for (int sum = 3; sum < sumsALen; sum++) {
            int sumB = sumsB[Math.min(sum - 1, bMax)]; // B가 sum-1 이하일 확률
            wins += sumB * sumsA[sum];
        }

        return wins;
    }

    // 선택된 주사위들로 만들 수 있는 합의 경우 수를 DP로 계산
    // dp[sum] = 해당 sum이 나오는 경우 수
    public int[] countSums(int mask) {
        int maxSum = getMaxSum(mask);   // DP 배열 크기 확보용
        int[] dp = new int[maxSum + 1];
        dp[0] = 1;  // 초기 상태: 합 0은 1가지

        // 선택된 주사위를 하나씩 적용하며 합 누적
        for (int i = 0; i < dice.length; i++) {
            if ((mask & (1 << i)) == 0) continue;

            int[] next = new int[maxSum + 1];
            for (int sum = 0; sum <= maxSum; sum++) {
                if (dp[sum] == 0) continue;

                // 현재 합 sum에 주사위 눈 face를 더한 새로운 합을 next에 누적
                for (int face : dice[i]) {
                    next[sum + face] += dp[sum];
                }
            }
            dp = next;
        }

        return dp;
    }

    // 선택된 주사위들의 최대 합을 계산 (dp 배열 크기 계산용)
    public int getMaxSum(int mask) {
        int sum = 0;
        int i = 0;

        // 비트마스크에 따라 선택된 주사위의 각 최댓값을 누적
        for (int[] d : dice) {
            if ((mask & (1 << i++)) != 0) {
                int max = 0;
                for (int n : d) {
                    max = Math.max(max, n);
                }
                sum += max;
            }
        }

        return sum;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[][] dice) {
        int n = dice.length;
        List<int[]> result = new ArrayList<>();
        List<Integer> Amasks = new ArrayList<>();
        
        // A 주사위 조합
        combination(0, n, 1, new int[n / 2], 0, result, Amasks);
        
        // 주사위 조합별 가능한 주사위 합의 수
        Map<Integer, List<Integer>> routeMap = dp(n, Amasks, dice);
        
        int maxSum = -1;
        int answerMask = 0;
        for (int aM : Amasks) {
            int routeSum = 0;
            List<Integer> aSums = routeMap.get(aM);
            
            for (Integer aSum : aSums) {
                int bM = ((1 << n) - 1) ^ aM;
                
                List<Integer> bSums = routeMap.get(bM);
                
                int left = 0;
                int right = bSums.size() - 1;

                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (bSums.get(mid) >= aSum) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                routeSum += right + 1;
            }
            
            
            if (routeSum > maxSum) {
                maxSum = routeSum;
                answerMask = aM;
            }
        }
        
        int[] answer = new int[n / 2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if ((answerMask & (1 << i)) != 0) {
                answer[index] = i + 1;
                index++;
            }
            
        }
        
        return answer;
    }
    
    static void combination(int depth, int n, int start, int[] path, int m, List<int[]> result, List<Integer> Amasks) {
        if (depth == path.length) {
            result.add(Arrays.copyOf(path, path.length));
            Amasks.add(m);
            
            return;
        }
        
        for (int i = start; i <= n; i++) {
            path[depth] = i;
            
            combination(depth + 1, n, i + 1, path, m | 1 << (i - 1), result, Amasks);
        }
    }
    
    static Map<Integer, List<Integer>> dp(int n, List<Integer> masks, int[][] dice) {
        Map<Integer, List<Integer>> routeSumMap = new HashMap<>();
        
        for (Integer m : masks) {
            List<Integer> sums = new ArrayList<>();
            dfs(0, 0, n / 2, m, dice, 0, sums);
            sums.sort((a, b) -> Integer.compare(a, b));
            routeSumMap.put(m, sums);
        }
        
        return routeSumMap;
    }
    
    static void dfs(int depth, int start, int pathSize, int mask, int[][] dice, int sum, List<Integer> sums) {
        if (depth == pathSize) {
            sums.add(sum);
            
            return;
        }
        
        for (int i = start; i < dice.length; i++) {
            if ((mask & (1 << i)) != 0) {
                
                for (int j = 0; j < 6; j++) {                    
                    dfs(depth + 1, i + 1, pathSize, mask, dice, sum + dice[i][j], sums);
                }
            }            
        }
    }
}
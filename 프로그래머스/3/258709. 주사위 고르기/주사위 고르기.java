import java.util.*;

class Solution {
    static int n;
    static int fullMask;
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        fullMask = (1 << n) - 1;
        Map<Integer, Map<Integer, Integer>> pathMap = new HashMap<>();
        
        for (int path = 0; path <= fullMask; path++) {
            if (Integer.bitCount(path) == n / 2) {
                Map<Integer, Integer> frequencyMap = new HashMap<>();
                getSumFrequencyMapOfPath(0, path, dice, 0, 0, frequencyMap);
                pathMap.put(path, frequencyMap);
            }
        }
        
        int maxSum = 0;
        int maxPath = 0;
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : pathMap.entrySet()) {
            int curSum = 0;
            
            int aPath = entry.getKey();
            int bPath = fullMask ^ aPath;
            
            for (Map.Entry<Integer, Integer> aFreqEntry : entry.getValue().entrySet()) {
                int aSum = aFreqEntry.getKey();
                int aSumCnt = aFreqEntry.getValue();
                
                for (Map.Entry<Integer, Integer> bFreqEntry : pathMap.get(bPath).entrySet()) {
                    int bSum = bFreqEntry.getKey();
                    int bSumCnt = bFreqEntry.getValue();
                    
                    if (aSum > bSum) {
                        curSum += aSumCnt * bSumCnt;
                    }
                }
            }
            
            if (curSum > maxSum) {
                maxSum = curSum;
                maxPath = aPath;
            }
        }
        
        int[] answer = new int[n / 2];
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            if ((maxPath & (1 << i)) != 0) {
                answer[index++] = i + 1;
            }
        }
        
        return answer;
    }
    
    static void getSumFrequencyMapOfPath(int depth, int path, int[][] dice, int start, int sum, Map<Integer, Integer> frequencyMap) {
        if (depth == dice.length / 2) {
            frequencyMap.put(sum, frequencyMap.getOrDefault(sum, 0) + 1);
            
            return;
        }
        
        for (int i = start; i < dice.length; i++) {
            if ((path & (1 << i)) == 0) {
                continue;
            }
            
            for (int j = 0; j < 6; j++) {
                getSumFrequencyMapOfPath(depth + 1, path, dice, i + 1, sum + dice[i][j], frequencyMap);
            }
        }
    }
    
}
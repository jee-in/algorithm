import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] success = new int[N + 1];
        int[] fail = new int[N + 1];
        List<float[]> result = new ArrayList<>();
        
        for (int s : stages) {
            if (s < N + 1) {
                fail[s] += 1;
            }
            
            for (int i = 1; i <= s; i++) {
                if (i == N + 1) break;
                success[i] += 1;
            }
        }
        
        for (int i = 1; i < N + 1; i++) {
            if (success[i] == 0) {
                result.add(new float[]{i, 0});
                continue;
            }
            
            result.add(new float[]{i, (float) fail[i] / success[i]});
        }
        result.sort((a, b) -> Float.compare(b[1], a[1]));
        
        return result.stream().mapToInt(x -> (int)x[0]).toArray();
    }
}
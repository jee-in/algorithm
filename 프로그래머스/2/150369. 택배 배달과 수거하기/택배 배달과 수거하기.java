import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1L;
        
        int dIdx = n - 1;
        int pIdx = n - 1;

        while (dIdx >= 0 || pIdx >= 0) {
            int dCap = cap;
            int pCap = cap;

            while (dIdx >= 0 && deliveries[dIdx] == 0) dIdx--;
            while (pIdx >= 0 && pickups[pIdx] == 0) pIdx--;

            if (dIdx < 0 && pIdx < 0) break;

            int farthest = Math.max(dIdx, pIdx);
            answer += (farthest + 1) * 2L;

            for (int i = dIdx; i >= 0 && dCap > 0; i--) {
                int toDeliver = Math.min(deliveries[i], dCap);
                deliveries[i] -= toDeliver;
                dCap -= toDeliver;
            }

            for (int i = pIdx; i >= 0 && pCap > 0; i--) {
                int toPickup = Math.min(pickups[i], pCap);
                pickups[i] -= toPickup;
                pCap -= toPickup;
            }
        }
                
        return answer + 1;
    }
}
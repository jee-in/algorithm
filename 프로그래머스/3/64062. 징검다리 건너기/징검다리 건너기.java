import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 0;
        int right = 200000000;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canTraverse(stones, mid, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    private boolean canTraverse(final int[] stones, final int mid, final int k) {
        
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - mid <= 0) {
                count++;
            } else {
                count = 0;
            }
            if (count >= k) {
                return false;
            }
        }
        
        return true;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        int[] solvingQueue = new int[3 * n];
        long q1Sum = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            q1Sum += queue1[i];
            total += (queue1[i] + queue2[i]);
            solvingQueue[i] = queue1[i];
            solvingQueue[i + n] = queue2[i];
            solvingQueue[i + 2 * n] = queue1[i];
        }

        if (total % 2 == 1) return -1;

        long target = total / 2;
        int depth = 0;
        int start = 0;
        int end = n - 1;

        while (depth <= 3 * n) {
                        
            if (q1Sum < target) {
                end++;
                if (end >= solvingQueue.length) break;
                q1Sum += solvingQueue[end];
            } else if (q1Sum > target) {
                q1Sum -= solvingQueue[start++];
            } else {
                return depth;
            }

            depth++;
        }

        return -1;
    }
}

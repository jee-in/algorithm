import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;

        for (int i : queue1) {
            q1.offer(i);
            sum1 += i;
        }
        for (int i : queue2) {
            q2.offer(i);
            sum2 += i;
        }

        int maxCount = queue1.length * 3;
        int count = 0;

        while (count <= maxCount) {
            if (sum1 == sum2) return count;

            if (sum1 > sum2) {
                int val = q1.poll();
                sum1 -= val;
                sum2 += val;
                q2.offer(val);
            } else {
                int val = q2.poll();
                sum2 -= val;
                sum1 += val;
                q1.offer(val);
            }
            count++;
        }

        return -1;
    }
}

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> first = new ArrayDeque<>();
        Queue<Integer> second = new ArrayDeque<>();

        long firstTotal = 0;
        long secondTotal = 0;
        for (int i = 0; i < queue1.length; i++) {
            first.add(queue1[i]);
            firstTotal += queue1[i];
            second.add(queue2[i]);
            secondTotal += queue2[i];
        }

        int term = 0;
        boolean flag = true;
        while (true) {
            if (firstTotal == secondTotal) {
                break;
            }
            if (term > queue1.length * 3) {
                flag = false;
                break;
            }

            if (firstTotal > secondTotal) {
                Integer poll = first.poll();
                firstTotal -= poll;
                second.add(poll);
                secondTotal += poll;
            } else {
                Integer poll = second.poll();
                secondTotal -= poll;
                first.add(poll);
                firstTotal += poll;
            }
            term++;
        }
        if (!flag) {
            return -1;
        }

        return term;
    }
}
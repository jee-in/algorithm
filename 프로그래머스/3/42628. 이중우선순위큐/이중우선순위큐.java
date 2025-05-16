import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        Queue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < operations.length; i++) {
            String[] operation = operations[i].split(" ");
            String operand = operation[0];
            Integer number = Integer.valueOf(operation[1]);
            
            if (operand.equals("I")) {
                pq.offer(number);
            } else if (operand.equals("D")) {
                if (pq.isEmpty()) continue;
                
                if (number == 1) {
                    try {
                        int max = Collections.max(pq);
                        pq.remove(max);
                    } catch (NoSuchElementException e) {
                        
                    }
                } else if (number == -1) {
                    pq.poll();
                }
            }
        }
                
        if (pq.isEmpty()) {
            return new int[]{0, 0};
        } else if (pq.size() == 1) {
            int min = pq.poll();
            return new int[]{min, min};
        } else {
            int max = Collections.max(pq);
            int min = pq.poll();
            return new int[]{max, min};
        }
    }
}
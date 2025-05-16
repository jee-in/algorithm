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
                    int max = pq.stream().mapToInt(Integer::valueOf).max().getAsInt();
                    pq.remove(max);
                } else if (number == -1) {
                    pq.poll();
                }
            }
        }
                
        if (pq.isEmpty()) {
            answer = new int[]{0, 0};
        } else {
            int max = pq.stream().mapToInt(Integer::valueOf).max().getAsInt();
            Integer min = pq.poll();
            
            answer = new int[]{max, min != null ? min : max};
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> minPq = new PriorityQueue<>();
        Queue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());         
        
        for (String operation: operations) {
            if (operation.charAt(0) == 'I') {
                Integer integer = Integer.valueOf(operation.substring(2));
                minPq.offer(integer);
                maxPq.offer(integer);
            } else if (operation.equals("D 1")) {
                if (maxPq.isEmpty()) continue;
                
                int max = maxPq.poll();
                minPq.remove(max);
            } else if (operation.equals("D -1")) {
                if (minPq.isEmpty()) continue;

                int min = minPq.poll();
                maxPq.remove(min);
            }
        }

        if (maxPq.isEmpty() && minPq.isEmpty()) {
            return new int[]{0, 0};
        }
        
        return new int[]{maxPq.poll(), minPq.poll()};
    }
}
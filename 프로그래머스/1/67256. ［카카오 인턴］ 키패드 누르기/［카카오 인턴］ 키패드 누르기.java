import java.util.*;

class Solution {    
    private static final int[] distTo2 = {3, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4, 4};
    private static final int[] distTo5 = {2, 2, 1, 2, 1, 0, 1, 2, 1, 2, 3, 3};
    private static final int[] distTo8 = {1, 3, 2, 3, 2, 1, 2, 1, 0, 1, 2, 2};
    private static final int[] distTo0 = {0, 4, 3, 4, 3, 2, 3, 2, 1, 2, 1, 1};
    
    private static final List<Integer> left = List.of(1, 4, 7, 10);
    private static final List<Integer> right = List.of(3, 6, 9, 11);
    
    public String solution(int[] numbers, String hand) {
        
        Map<Integer, int[]> map = new HashMap<>();
        map.put(2, distTo2);
        map.put(5, distTo5);
        map.put(8, distTo8);
        map.put(0, distTo0);
        
        StringBuilder sb = new StringBuilder();
        
        int curLeft = 10;
        int curRight = 11;
        
        for (int n : numbers) {
            if (left.contains(n)) {
                sb.append("L");
                curLeft = n;
            } else if (right.contains(n)) {
                sb.append("R");
                curRight = n;
            } else {
                if (map.get(n)[curLeft] < map.get(n)[curRight]) {
                    sb.append("L");
                    curLeft = n;
                } else if (map.get(n)[curLeft] > map.get(n)[curRight]) {
                    sb.append("R");
                    curRight = n;
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        curLeft = n;
                    } else {
                        sb.append("R");
                        curRight = n;
                    }
                }
            }
        }
        
        return sb.toString();
    }
}
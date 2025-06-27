import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String[] splitted = s.substring(2, s.length() - 2).split("\\},\\{");
        Arrays.sort(splitted, Comparator.comparingInt(x -> x.length()));
        
        Set<Integer> used = new HashSet<>();
        int[] answer = new int[splitted.length];
        int idx = 0;
        for (String set : splitted) {
            for (String setElem: set.split(",")) {
                int number = Integer.valueOf(setElem);
                if (used.add(number)) {
                    answer[idx++] = number;
                }
            }
        }
            
        return answer;
    }
}
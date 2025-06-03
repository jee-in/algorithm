import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        int[] scores = {0, 3, 2, 1, 0, 1, 2, 3};
        Map<Character, Integer> map = new HashMap<>();
        for (char[] t : types) {
            map.put(t[0], 0);
            map.put(t[1], 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            char typeA = survey[i].charAt(0);
            char typeB = survey[i].charAt(1);
            
            int choice = choices[i];
            
            if (choice <= 3) {
                map.put(typeA, map.get(typeA) + scores[choice]);
            } else if (choice >= 5) {
                map.put(typeB, map.get(typeB) + scores[choice]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char[] t : types) {
            int scoreA = map.get(t[0]);
            int scoreB = map.get(t[1]);
            
            if (scoreA >= scoreB) {
                sb.append(t[0]);
            } else if (scoreA < scoreB) {
                sb.append(t[1]);
            }
        }
        
        return sb.toString();
    }
}
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        
        List<Character> types = List.of('R', 'T', 'C', 'F', 'J', 'M', 'A', 'N');
        for (Character t : types) {
            map.put(t, 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            Character type1 = survey[i].charAt(0);
            Character type2 = survey[i].charAt(1);
            
            int choice = choices[i];
            
            if (choice <= 3) {
                map.put(type1, map.get(type1) + (4 - choice));
            } else if (choice >= 5) {
                map.put(type2, map.get(type2) + (choice - 4));
            }
        }
                
        List<Character[]> metrics = List.of(new Character[]{'R', 'T'}, new Character[]{'C', 'F'}, 
                                          new Character[]{'J', 'M'}, new Character[]{'A', 'N'});
        
        for (Character[] metric : metrics) {
            Character a = metric[0];
            Character b = metric[1];
            
            int aScore = map.get(a);
            int bScore = map.get(b);
            
            if (aScore > bScore) {
                answer += a;
            } else if (aScore < bScore) {
                answer += b;
            } else {
                answer += a;
            }
        }
        
        return answer;
    }
}
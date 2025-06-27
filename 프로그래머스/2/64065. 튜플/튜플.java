import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(s);
        
        while (matcher.find()) {
            Integer a = Integer.valueOf(matcher.group());
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        int n = map.size();
        int[] answer = new int[n];        
        for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
            answer[n - entry.getValue()] = entry.getKey();
        }
        
        return answer;
    }
}
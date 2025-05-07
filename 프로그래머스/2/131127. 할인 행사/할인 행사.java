import java.util.*;
import java.util.stream.*;

class Solution {
    private static int salePeriod = 10;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int start = 0; start < discount.length - 10 + 1; start++) {
            
            Map<String, Integer> tempMap = new HashMap<>(map);
            for (int index = start; index < start + 10; index++) {
                if (tempMap.containsKey(discount[index])) {
                    tempMap.put(discount[index], tempMap.get(discount[index]) - 1);
                }
            }
                                
            if (tempMap.entrySet().stream().filter(entry -> entry.getValue() > 0).count() <= 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
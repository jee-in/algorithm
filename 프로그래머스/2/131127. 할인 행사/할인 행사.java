import java.util.*;

class Solution {
    private static final int SALE_PERIOD = 10;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        final Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        Map<String, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < SALE_PERIOD; i++) {
            windowMap.put(discount[i], windowMap.getOrDefault(discount[i], 0) + 1);
        }
        
        if (matches(wantMap, windowMap)) {
            answer++;
        }
        
        for (int i = SALE_PERIOD; i < discount.length; i++) {       
            windowMap.put(discount[i - SALE_PERIOD], windowMap.getOrDefault(discount[i - SALE_PERIOD], 0) - 1);
            if (windowMap.get(discount[i - SALE_PERIOD]) <= 0) {
                windowMap.remove(discount[i - SALE_PERIOD]);
            }
            
            windowMap.put(discount[i], windowMap.getOrDefault(discount[i], 0) + 1);
            
            if (matches(wantMap, windowMap)) {
                answer++;
            }
        }
        
        
        return answer;
    }
    
    private boolean matches(Map<String, Integer> wantMap, Map<String, Integer> windowMap) {
        for (Map.Entry<String, Integer> entry: wantMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            
            if (windowMap.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }
}
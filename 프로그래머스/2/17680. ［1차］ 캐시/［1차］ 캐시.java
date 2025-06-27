import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();

        for (String c : cities) {
            String key = c.toLowerCase();
            
            if (cache.contains(key)) {
                answer += 1;
                cache.remove(key);
            } else {
                answer += 5;
                
                if (cache.size() >= cacheSize) {
                    cache.poll();
                }
            }
            
            cache.offer(key);
        }
        
        return answer;
    }
}
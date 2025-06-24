import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        
        for (String city : cities) {
            String key = city.toLowerCase();
            
            if (cache.contains(key)) {
                cache.remove(key);
                answer += 1;
            } else {
                if (cacheSize > 0 && cache.size() >= cacheSize) {
                    cache.poll();
                }
                answer += 5;
            }
            
            if (cacheSize > 0) {
                cache.offer(key);
            }
        }
        
        return answer;
    }
}

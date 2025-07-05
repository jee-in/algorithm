import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        String[] set1 = getMultiSet(str1.toLowerCase());
        String[] set2 = getMultiSet(str2.toLowerCase());
        
        if (set1.length == 0 && set2.length == 0) return 65536;
        
        Map<String, Integer> set1Map = calculateMap(set1);
        Map<String, Integer> set2Map = calculateMap(set2);
        
        Map<String, Integer> unionMap = new HashMap<>();
        Map<String, Integer> setMap = new HashMap<>();
        
        Set<String> totalSet = new HashSet(set1Map.keySet());
        totalSet.addAll(set2Map.keySet());
        
        int unionSize = 0;
        int setSize = 0;
        for (String key : totalSet) {
            int v1 = set1Map.getOrDefault(key, 0);
            int v2 = set2Map.getOrDefault(key, 0);
            
            unionSize += Math.max(v1, v2);
            setSize += Math.min(v1, v2);
        }
        
        return (int) ((setSize / (float) unionSize) * 65536);
    }
    
    private static String[] getMultiSet(String s) {
        List<String> result = new ArrayList<>();
        String processed = s.replaceAll("[^a-z]", " ");
        
        for (int i = 0; i < processed.length() - 1; i++) {
            String temp = processed.substring(i, i + 2).trim();
            if (temp.length() == 2) {
                result.add(temp);
            }
        }
        
        return result.stream().toArray(String[]::new);
    }
    
    private static Map<String, Integer> calculateMap(String[] arr) { 
        Map<String, Integer> map = new HashMap<>();
        
        for (String a : arr) {            
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        return map;
    }
}
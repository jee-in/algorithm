import java.util.*;
import java.util.stream.*;

class Solution {
    private static final int UNICODE_A = 65;
    private static final int ALPHABET_SIZE = 26;

    public String[] solution(String[] orders, int[] course) {      
        
        int[] ordersInBit = new int[orders.length];
        for (int i = 0; i < orders.length; i++) {
            String o = orders[i];
            ordersInBit[i] = convertStringToBitMap(o);
        }
        
        Set<Integer> comb = new HashSet<>();
        for (int i = 0; i < ordersInBit.length - 1; i++) {
            int o1 = ordersInBit[i];
            
            for (int j = i + 1; j < ordersInBit.length; j++) {
                int o2 = ordersInBit[j];
                                
                int match = o1 & o2;
                if (Integer.bitCount(match) > 1) {
                    
                    String matchedMenu = convertBitMapToString(match);
                    for (int k = 0; k < course.length; k++) {
                        dfs(course[k], 0, "", matchedMenu, comb);
                    }
                }
            }
        }
        
        System.out.println(comb);
                    
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer c : comb) {
            if (map.get(c) != null) continue;

            int cnt = 0;
            for (int i = 0; i < ordersInBit.length; i++) {
                int o = ordersInBit[i];
                int match = c & o;

                if (Integer.bitCount(match) == Integer.bitCount(c)) {
                    cnt++;
                }
            }      
            
            map.put(c, cnt);
        }
        
        System.out.println(map);

        List<String> result = new ArrayList<>();
        int[] maxPerCourse = new int[11];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer bitMap = entry.getKey();
            Integer count = entry.getValue();
            
            String menu = convertBitMapToString(bitMap);
            if (count > maxPerCourse[menu.length()]) {
                maxPerCourse[menu.length()] = count;
            }
        }
        System.out.println(Arrays.toString(maxPerCourse));
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer bitMap = entry.getKey();
            Integer count = entry.getValue();
            
            String menu = convertBitMapToString(bitMap);
            if (count >= maxPerCourse[menu.length()]) {
                result.add(menu);
            }
        }
        
        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
    
    private static void dfs(int depth, int start, String path, String source, Set<Integer> comb) {
        if (depth == 0) {
            comb.add(convertStringToBitMap(path));
            
            return;
        }
        
        for (int i = start; i < source.length(); i++) {
            dfs(depth - 1, i + 1, path + source.substring(i, i + 1), source, comb);
        }
    }
    
    private static String convertBitMapToString(int bitMap) {
                            
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            int charBit = 1 << i;

            if ((bitMap & charBit) > 0) {
                String menu = String.valueOf((char) (i + UNICODE_A));
                sb.append(menu);
            }
        }
        
        return sb.toString();
    }
    
    private static Integer convertStringToBitMap(String s) {
        int bit = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            int mark = c - UNICODE_A;

            bit |= 1 << mark;
        }
        
        return bit;
    }
    
    private static boolean canBeCourseSize(int n, int[] course) {
        for (int i  = 0; i < course.length; i++) {
            if (n == course[i]) return true;
        }
        return false;
    }
}
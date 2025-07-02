import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int code = 27;
        int size = msg.length();
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> encodingMap = new HashMap<>();
        
        for (int i = 0; i < 26; i++) {
            encodingMap.put(String.valueOf((char) ('A' + i)) , i + 1);
        }
        
        int curIdx = 0;
        while (curIdx < size) {
            String curStr = String.valueOf(msg.charAt(curIdx));
            
            int i = 2;            
            for (; i <= (size - curIdx); i++) {
                if (encodingMap.get(msg.substring(curIdx, curIdx + i)) == null) {
                    i -= 1;
                    break;
                }
                curStr = msg.substring(curIdx, curIdx + i);
            }
            
            result.add(encodingMap.get(curStr));
            if (curIdx + curStr.length() + 1 <= size) {
                encodingMap.put(msg.substring(curIdx, curIdx + curStr.length() + 1), code++);
            }
            curIdx += curStr.length();
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
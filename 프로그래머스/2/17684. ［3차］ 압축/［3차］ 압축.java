import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> encodingMap = new HashMap<>();
        int code = 27;
        int size = msg.length();
        
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
            
            if (curStr.length() == 1) {
                list.add(curStr.charAt(0) - 64);
                if (curIdx + 2 <= size) {
                    encodingMap.put(msg.substring(curIdx, curIdx + 2), code++);
                }
                curIdx++;
            } else {
                list.add(encodingMap.get(curStr));
                if (curIdx + i + 1 <= size) {
                    encodingMap.put(msg.substring(curIdx, curIdx + i + 1), code++);
                }
                curIdx = curIdx + i;
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
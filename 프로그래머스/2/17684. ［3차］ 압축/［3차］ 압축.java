import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int code = 27;
        int size = msg.length();
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> encodingMap = new HashMap<>();
        
        // 사전 Map 초기화
        for (int i = 0; i < 26; i++) {
            encodingMap.put(String.valueOf((char) ('A' + i)) , i + 1);
        }
        
        int curIdx = 0;
        while (curIdx < size) {
            String curStr = String.valueOf(msg.charAt(curIdx));
            
            // 한 글자 이상 단어가 있는지 탐색
            for (int i = 2; i <= (size - curIdx); i++) {
                String temp = msg.substring(curIdx, curIdx + i);
                if (encodingMap.get(temp) == null) {
                    break;
                }
                curStr = temp;
            }
            
            // 압축 결과 저장 및 사전 업데이트
            result.add(encodingMap.get(curStr));
            if (curIdx + curStr.length() + 1 <= size) {
                encodingMap.put(msg.substring(curIdx, curIdx + curStr.length() + 1), code++);
            }
            
            // 다음 탐색 시작점 업데이트
            curIdx += curStr.length();
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

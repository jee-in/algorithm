import java.util.*;

class Solution {
    private static final int SALE_PERIOD = 10;

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        Map<String, Integer> windowMap = new HashMap<>();

        for (int i = 0; i < SALE_PERIOD; i++) {
            windowMap.put(discount[i], windowMap.getOrDefault(discount[i], 0) + 1);
        }

        if (matches(wantMap, windowMap)) answer++;

        for (int i = SALE_PERIOD; i < discount.length; i++) {
            String outItem = discount[i - SALE_PERIOD]; 
            String inItem = discount[i];

            windowMap.put(outItem, windowMap.get(outItem) - 1);
            if (windowMap.get(outItem) == 0) windowMap.remove(outItem);

            windowMap.put(inItem, windowMap.getOrDefault(inItem, 0) + 1);

            if (matches(wantMap, windowMap)) answer++;
        }

        return answer;
    }

    private boolean matches(Map<String, Integer> want, Map<String, Integer> window) {
        for (Map.Entry<String, Integer> entry : want.entrySet()) {
            String item = entry.getKey();
            int required = entry.getValue();
            if (window.getOrDefault(item, 0) < required) {
                return false;
            }
        }
        return true;
    }
}

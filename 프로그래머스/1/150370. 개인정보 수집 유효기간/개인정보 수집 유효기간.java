import java.time.*;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        int[] arr = Arrays.stream(today.split("\\.")).mapToInt(s -> Integer.valueOf(s)).toArray();
        LocalDate todayDate = LocalDate.of(arr[0], arr[1], arr[2]);        
        
        Map<String, Integer> termMap = new HashMap<>();
        for (String t : terms) {
            String[] termInfo = t.split(" ");
            termMap.put(termInfo[0], Integer.valueOf(termInfo[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] privacyInfo = privacy.split(" ");
            
            Integer duration = termMap.get(privacyInfo[1]);
            int[] termArr = Arrays.stream(privacyInfo[0].split("\\.")).mapToInt(s -> Integer.valueOf(s)).toArray();
            LocalDate createdAt = LocalDate.of(termArr[0], termArr[1], termArr[2]);
                        
            if (todayDate.isAfter(createdAt.plusMonths(duration).minusDays(1)) ) {
                answer.add(i + 1);
            }            
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
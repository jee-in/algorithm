import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> parkingTimeMap = new HashMap<>();
        Map<Integer, Stack<Integer>> inCarMap = new HashMap<>();

        for (String r : records) {
            String[] splitted = r.split(" ");
            String[] time = splitted[0].split(":");
            Integer number = Integer.valueOf(splitted[1]);
            String type = splitted[2];
            
            if (type.equals("IN")) {
                int inTime = Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
                inCarMap.computeIfAbsent(number, (k) -> new Stack<>()).push(inTime);
            } else {
                int outTime = Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
                int inTime = inCarMap.get(number).pop();
                
                int duration = outTime - inTime;
                int prev = parkingTimeMap.getOrDefault(number, 0);
                parkingTimeMap.put(number, prev + duration);
            }
        }
        
        int endTime = 23 * 60 + 59;
        for (Map.Entry<Integer, Stack<Integer>> entry: inCarMap.entrySet()) {
            Integer number = entry.getKey();
            Stack<Integer> stack = entry.getValue();
                            
            int prev = parkingTimeMap.getOrDefault(number, 0);
            if (!stack.isEmpty()) {
                int inTime = stack.pop();
                int duration = endTime - inTime;
                parkingTimeMap.put(number, prev + duration);
            }
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(parkingTimeMap.entrySet());
        Collections.sort(entryList, Comparator.comparingInt(x -> x.getKey()));
        
        int[] answer = new int[entryList.size()];
        for (int i = 0; i < entryList.size(); i++) {
            Map.Entry<Integer, Integer> entry = entryList.get(i);
            
            int parkingFee = fees[1];
            if (entry.getValue() > fees[0]) {
                parkingFee += (int)Math.ceil(((float)entry.getValue() - fees[0]) / fees[2]) * fees[3];
            }
            
            answer[i] = parkingFee;
        }
        
        return answer;
    }
}
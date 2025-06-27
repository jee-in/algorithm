import java.util.*;

class Solution {
    private static String enterMessage = "님이 들어왔습니다.";
    private static String leaveMessage = "님이 나갔습니다.";
    
    public String[] solution(String[] record) {
        
        Map<String, String> map = new HashMap<>();
        for (String r : record) {
            String[] tokens = r.split(" ");
            String type = tokens[0];
            String id = tokens[1];
            
            if (type.equals("Enter") | type.equals("Change")) {
                map.put(id, tokens[2]);
            }
        }
        
        List<String> logs = new ArrayList<>();
        for (String r: record) {
            String[] tokens = r.split(" ");
            String type = tokens[0];
            String id = tokens[1];
            
            if (type.equals("Enter")) {
                logs.add(map.get(id) + enterMessage);
            } else if (type.equals("Leave")) {
                logs.add(map.get(id) + leaveMessage);
            }
        }
        
        return logs.toArray(new String[0]);
    }
}
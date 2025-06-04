class Solution {
    public String solution(String new_id) {
        
        StringBuilder sb = new StringBuilder();
        boolean prevDot = false;
        for (int i = 0; i < new_id.length(); i++) {
            Character c = new_id.charAt(i);
            
            if (Character.isLetterOrDigit(c) || c == '-' || c == '_' || c == '.') {
                if (c == '.') {
                    prevDot = true;
                    continue;
                }
                
                if (prevDot) {
                    sb.append(".");
                }
                prevDot = false;
                
                sb.append(Character.toLowerCase(c));
            }
        }
        
        String temp = sb.toString();
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < temp.length(); i++) {
            Character c = temp.charAt(i);
            
            if (c == '.' && (i == 0 || i == temp.length() - 1)) {
                continue;
            }
            
            answer.append(c);
        }
        
        if (answer.length() == 0) {
            answer.append("a");
        }
        
        if (answer.length() >= 16) {
            answer.delete(15, answer.length());
            
            if (answer.charAt(14) == '.') {
                answer.deleteCharAt(14);
            }
        }
        
        while (answer.length() <= 2) {
            answer.append(answer.charAt(answer.length() - 1));
        }
                
        return answer.toString();
    }
}
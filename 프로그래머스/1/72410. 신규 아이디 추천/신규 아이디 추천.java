class Solution {
    public String solution(String new_id) {
        
        boolean prevDot = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            Character c = new_id.charAt(i);
            
            if (Character.isLetterOrDigit(c) || c == '-' || c == '_' || c == '.') {
                if (c == '.') {
                    prevDot = true;
                    continue;
                } else {
                    if (prevDot) {
                        sb.append(".");
                        prevDot = false;
                    }
                }
                
                sb.append(Character.toLowerCase(c));
            }
        }
        
        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (sb.length() == 0) {
            sb.append("a");
        }
        
        if (sb.length() >= 16) {
            sb.delete(15, sb.length());
            
            if (sb.charAt(14) == '.') {
                sb.deleteCharAt(14);
            }
        }
        
        while (sb.length() <= 2) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        
        return sb.toString();
    }
}
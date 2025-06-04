class Solution {
    public String solution(String new_id) {
        
        StringBuilder sb = new StringBuilder();
        
        // 유효한 문자만 소문자로 담되, 연속되는 '.' 는 하나만 담고 마지막 '.'는 담지 않음
        boolean prevDot = false;
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
        
        // 처음에 있는 '.' 제거
        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        
        // 빈 문자열이라면 "a" 대입
        if (sb.length() == 0) {
            sb.append("a");
        }
        
        // 길이가 16자 이상이면 첫 15개 문자만 남기고, 마지막 문자가 '.'이면 제거
        if (sb.length() >= 16) {
            sb.delete(15, sb.length());
            
            if (sb.charAt(14) == '.') {
                sb.deleteCharAt(14);
            }
        }
        
        // 길이가 2자 이하라면 길이가 3이 될 때까지 마지막 문자를 반복해서 추가
        while (sb.length() <= 2) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        
        return sb.toString();
    }
}
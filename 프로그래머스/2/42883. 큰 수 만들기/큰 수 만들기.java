import java.util.*;

class Solution {
    public String solution(String number, int k) {        
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        
        while (index < number.length()) {
            int num = Character.getNumericValue(number.charAt(index));
            
            while (!stack.isEmpty() && k > 0 && stack.peek() < num) {
                stack.pop();
                k--;    
            }
            
            stack.push(num);
            index++;
        }
        
        if (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        
        return sb.toString();
    }
}
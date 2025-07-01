import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n % k);
            n /= k;
        }
        
        int maxDigit = stack.size() - 1;
        int digit = maxDigit;

        StringBuilder cur = new StringBuilder();
        while (!stack.empty()) {
            int s = stack.pop();
            
            if (s == 0) {                
                if (check(cur, k)) {
                    answer++;
                }
                cur.setLength(0);
            } else {
                cur.append(String.valueOf(s));
            }
            
            digit--;
        }
        
        if (check(cur, k)) {
            answer++;
        }
        
        return answer;
    }
    
    private static boolean check(StringBuilder cur, int k) {
        if (cur.length() < 1) {
            return false;
        }
        
        if (isPrimeNumber(Long.valueOf(cur.toString()))) {
            return true;
        }
        return false;
    }
    
    private static boolean isPrimeNumber(Long n) {
        if (n < 2) return false;
        int a = (int) Math.sqrt(n);
        
        for (int i = 2; i <= a; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}
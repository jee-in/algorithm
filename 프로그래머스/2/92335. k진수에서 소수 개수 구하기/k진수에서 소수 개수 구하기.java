import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        String converted = sb.reverse().toString();
        String[] splitted = converted.split("0");
        
        int answer = (int) Arrays.stream(splitted)
            .filter(x -> x.length() > 0)
            .filter(x -> isPrime(Long.valueOf(x)))
            .count();
        
        return answer;
    }
    
    private static boolean isPrime(Long x) {
        if (x < 2) return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
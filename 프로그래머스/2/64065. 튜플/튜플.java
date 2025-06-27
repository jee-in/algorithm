import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

class Solution {
    public int[] solution(String s) {
        
        Pattern trimPattern = Pattern.compile("^(\\{\\{)|(\\}\\})$");
        Matcher matcher = trimPattern.matcher(s);
        String trimmedString = matcher.replaceAll("");
        
        Pattern pattern = Pattern.compile("\\},\\{");
        String[] splitted = pattern.split(trimmedString);
        Arrays.sort(splitted, Comparator.comparingInt(x -> x.length()));
        
        int n = splitted.length;
        int[] answer = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String elem = splitted[i];
            int[] arr = Arrays.stream(elem.split(","))
                .mapToInt(x -> Integer.valueOf(x).intValue())
                .toArray();
            
            for (int a : arr) {
                if (!set.contains(a)) {
                    answer[i] = a;
                    set.add(a);
                }
            }
        }
        
        return answer;
    }
}
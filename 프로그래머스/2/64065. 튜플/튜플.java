import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String s) {
        String source = s.substring(1, s.length() - 1);     
        String[] array = source.split("},");                
        
        int[][] finalArray = Arrays.stream(array).map(elem -> {
            if (elem.charAt(elem.length() - 1) == '}') {
                elem = elem.substring(1, elem.length() - 1);
            } else {
                elem = elem.substring(1);
            }
            
            return Arrays.stream(elem.split(",")).map(Integer::valueOf).mapToInt(Integer::intValue).toArray();
        }).toArray(int[][]::new);
        Arrays.sort(finalArray, Comparator.comparingInt(a -> a.length));

        int[] answer = new int[finalArray.length];        
        for (int i = 0; i < finalArray.length; i++) {
            
            r: for (int j = 0; j < finalArray[i].length; j++) {
                int candidate = finalArray[i][j];
                    
                for (int k = 0; k < i; k++) {
                    if (candidate == answer[k]) {
                        continue r;
                    }
                }
                answer[i] = candidate;
            }
        }
        
        return answer;
    }
}
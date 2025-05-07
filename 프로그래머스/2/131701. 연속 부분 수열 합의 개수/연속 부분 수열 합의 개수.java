import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> set = new HashSet<>();
        for (int size = 1; size < elements.length + 1; size++) {
            for (int start = 0; start < elements.length; start++) {
                int sum = 0;
                for (int i = start; i < start + size; i++) {
                    sum += elements[i % elements.length];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}
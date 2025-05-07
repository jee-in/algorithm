import java.util.*;

class Solution {
    private static int salePeriod = 10;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        List<String> wantList = Arrays.asList(want);
                
        for (int start = 0; start < discount.length - salePeriod + 1; start++) {
            List<String> discountList = Arrays.asList(Arrays.copyOfRange(discount, start, start + salePeriod + 1));
            if(!discountList.containsAll(wantList)) {
                continue;
            }
             
            int[] numberCopy = Arrays.copyOf(number, number.length);
            for (int discountIdx = start; discountIdx < start + salePeriod; discountIdx++) {
                for (int wantIdx = 0; wantIdx < want.length; wantIdx++) {
                    if (discount[discountIdx].equals(want[wantIdx])) {
                        numberCopy[wantIdx]--;
                    }
                }
            }
            long result = Arrays.stream(numberCopy).filter(no -> no > 0).count();
            if (result <= 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
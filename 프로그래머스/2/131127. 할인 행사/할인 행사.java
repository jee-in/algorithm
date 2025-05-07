import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        ArrayList<String> wantList = new ArrayList<>();
        
        for (int i = 0; i< want.length; i++) {
            while (number[i]-- > 0) {
                wantList.add(want[i]);
            }
        }

        for (int i = 0; i< discount.length - wantList.size() + 1; i ++) {
            ArrayList<String> wantListCopy = (ArrayList<String>) wantList.clone();
            
            for (int j = i; j < i + wantList.size(); j++) {
                if (wantListCopy.contains(discount[j])) {
                    wantListCopy.remove(discount[j]);
                } else {
                    break;
                }
            }
            answer += wantListCopy.size() == 0 ? 1 : 0;
        }

        return answer;
    }
}
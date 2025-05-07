import java.util.*;
import java.util.stream.*;

class Solution {
    private int[] discountRateList = {10, 20, 30, 40};
    private int maxSubscriber = 0;
    private int maxRevenue = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {        
        int[] curPayment = new int[users.length];
        dfs(0, emoticons, users, curPayment);
        int[] answer = {maxSubscriber, maxRevenue};
        return answer;
    }
    
    private void dfs(int depth, final int[] emoticons, final int[][] users, int[] curPayment) {
        if (depth == emoticons.length) {
            
            int curSubscriber = (int)Arrays.stream(curPayment).filter(payment -> payment == -1).count();
            int curRevenue = Arrays.stream(curPayment).filter(payment -> payment != -1).sum();

            if (maxSubscriber < curSubscriber) {
                maxSubscriber = curSubscriber;
                maxRevenue = curRevenue;
            } else if (maxSubscriber == curSubscriber) {
                maxRevenue = Math.max(maxRevenue, curRevenue);
            }
            return;
        }

        int emoticonPrice = emoticons[depth];
        for (int i = 0; i < discountRateList.length; i++) {
            int discountRate = discountRateList[i];

            int[] copyCurPayment = Arrays.copyOf(curPayment, curPayment.length);
            for (int j = 0; j < users.length; j++) {
                int userRate = users[j][0];
                int userBudget = users[j][1];

                if (copyCurPayment[j] != -1 && userRate <= discountRate) {
                    copyCurPayment[j] += (int)(100 - discountRate)/100.0 * emoticonPrice;
                    
                    if (copyCurPayment[j] >= userBudget) {
                        copyCurPayment[j] = -1;
                    }
                }
            }
            
            dfs(depth + 1, emoticons, users, copyCurPayment);
        }
    }
}



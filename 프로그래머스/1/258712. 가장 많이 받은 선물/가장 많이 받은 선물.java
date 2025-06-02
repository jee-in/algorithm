import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int[] futures = new int[friends.length];
        int[] scores = new int[friends.length];
        int[][] transactions = new int[friends.length][friends.length];
        
        Map<String, Integer> friendIdxMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendIdxMap.put(friends[i], i);
        }
        
        for (String gift : gifts) {
            String[] friendArr = gift.split(" ");
            int giver = friendIdxMap.get(friendArr[0]);
            int receiver = friendIdxMap.get(friendArr[1]);
            
            transactions[giver][receiver] += 1;
            scores[giver] += 1;
            scores[receiver] -= 1;
        }
        
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j <friends.length; j++) {
                if (transactions[i][j] > transactions[j][i]) {
                    futures[i] += 1;
                } else if (transactions[i][j] == transactions[j][i]) {
                 
                    if (scores[i] > scores[j]) {
                        futures[i] += 1;
                    }
    
                }
            }
        }
        
        return IntStream.of(futures).max().getAsInt();
    }
}
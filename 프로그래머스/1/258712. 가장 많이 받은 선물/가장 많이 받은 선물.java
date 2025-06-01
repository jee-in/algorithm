import java.util.*;

class Friend {
    private int score = 0;
    private int future = 0;
    
    public int getScore() {
        return this.score;
    }
    
    public int getFuture() {
        return this.future;
    }
    
    public void plusScore() {
        this.score += 1;
    }
    
    public void minusScore() {
        this.score -= 1;
    }
    
    public void plusFuture() {
        this.future += 1;
    }
    
    @Override
    public String toString() {
        return "Friend(" + "score: " + score + ", future: " + future + ")";
    }
}

class Solution {
    private static Map<String, int[]> transactions = new HashMap<>();
    private static Map<String, Friend> friendMap = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Arrays.sort(friends);
        combination(0, 0, "", friends);
        
        for (String f : friends) {
            friendMap.put(f, new Friend());
        }
        
        for (String g : gifts) {
            String[] giving = g.split(" ");
            String f1 = giving[0];
            String f2 = giving[1];
            
            friendMap.get(f1).plusScore();
            friendMap.get(f2).minusScore();
            
            Arrays.sort(giving);             
            String key = giving[0] + "-" +giving[1];
            if (f1.compareTo(f2) < 0) {
                transactions.get(key)[0] += 1;
            } else {
                transactions.get(key)[1] += 1;
            }
        }
        
        for (Map.Entry<String, int[]> entry : transactions.entrySet()) {
            String[] fs = entry.getKey().split("-");
            String f1 = fs[0];
            String f2 = fs[1];
            
            int[] ts = entry.getValue();
            if (ts[0] > ts[1]) {
                friendMap.get(f1).plusFuture();
            } else if (ts[0] < ts[1]) {
                friendMap.get(f2).plusFuture();
            } else {
                int f1Score = friendMap.get(f1).getScore();
                int f2Score = friendMap.get(f2).getScore();
                
                if (f1Score > f2Score) {
                    friendMap.get(f1).plusFuture();
                } else if (f1Score < f2Score) {
                    friendMap.get(f2).plusFuture();
                }
            }
        }
        
        for (Map.Entry<String, Friend> entry : friendMap.entrySet()) {
            answer = Math.max(answer, entry.getValue().getFuture());    
        }
        
        return answer;
    }
    
    static void combination (int depth, int start, String path, String[] friends) {
        if (depth == 2) {
            transactions.put(path, new int[2]);
            return;
        }
        
        if (depth == 1) {
            path += "-";
        }
        
        for (int i = start; i < friends.length; i++) {
            combination(depth + 1, i + 1, path + friends[i], friends);
        }
    }
}
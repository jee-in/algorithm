import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visited = new boolean[words.length];
        Queue<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (canChange(begin, word)) {
                deque.offer(i);
                visited[i] = true;
            }
        }
        
        int level = 0;
        while(!deque.isEmpty()) {
            level++;
            
            int nextNodeCnt = deque.size();
            for (int i = 0; i < nextNodeCnt; i++) {
                Integer curIdx = deque.poll();
                String curWord = words[curIdx];
                visited[curIdx] = true;
                
                if (curWord.equals(target)) {
                    return level;
                }
                
                for (int j = 0; j < words.length; j++) {
                    String word = words[j];
                    if (!visited[j] && canChange(curWord, word)) {
                        deque.offer(j);
                        visited[j] = true;
                    }
                }
            }
        }
        
        return 0;
    }
    
    private boolean canChange(String a, String b) {
        int diffLetterCnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffLetterCnt++;
            }
        }
        return diffLetterCnt == 1;
    } 
}
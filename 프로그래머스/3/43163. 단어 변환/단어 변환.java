class Solution {
    private int answer = 0;
    
    public int solution(String begin, String target, String[] words) {        
        boolean[] visited = new boolean[words.length];
        canBeTarget(0, words, begin, target, visited);
        
        return answer;
    }
    
    private void canBeTarget(int depth, final String[] words, String curWord, final String target, boolean[] visited) {
        
        if (curWord.equals(target)) {
            answer = depth;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!visited[i] && canChange(curWord, word)) {
                visited[i] = true;
                canBeTarget(depth + 1, words, words[i], target, visited);
                visited[i] = false;
            }
        }
        
        
    }
    
    private boolean canChange(String s1, String s2) {
        int diffLetterCnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffLetterCnt++;
            }
            
            if (diffLetterCnt > 1) return false;
        }
        
        return diffLetterCnt == 1;
    }
}
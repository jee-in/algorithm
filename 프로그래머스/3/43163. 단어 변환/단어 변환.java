import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < words.length; i++) {
            if (isOneLetterDiff(begin, words[i])) {
                visited[i] = true;
                queue.offer(i);
            }
        }

        int level = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int k = 0; k < queueSize; k++) {
                int curIndex = queue.poll();
                String curStr = words[curIndex];
                if (curStr.equals(target)) return level;

                for (int i = 0; i < words.length; i++) {
                    if (!visited[i] && isOneLetterDiff(curStr, words[i])) {
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }

            level++;
        }

        return 0;
    }

    private boolean isOneLetterDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }
}

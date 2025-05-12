import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int level = 0;
    
    public int solution(int[][] maps) {
        bfs(maps);
        
        return level;
    }
    
    static void bfs(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        
        while(!deque.isEmpty()) {
            
            int N = deque.size();
            for (int i = 0; i < N; i++) {
                int[] pos = deque.poll();
                if (pos[0] == maps.length - 1 && pos[1] == maps[0].length - 1) {
                    level++;
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int drow = pos[0] + dx[j];
                    int dcol = pos[1] + dy[j];

                    if (isValidPos(drow, dcol, maps) && !visited[drow][dcol]) {
                        deque.offer(new int[]{drow, dcol});
                        visited[drow][dcol] = true;
                    }
                }
                
            }
            
            level++;
        }
        
        level = -1;
        return;
    }
    
    static boolean isValidPos(int x, int y, int[][] maps) {
        if (x >= 0 && y >= 0 && x < maps.length && y < maps[0].length && maps[x][y] == 1) {
            return true;
        }
        return false;
    }
}
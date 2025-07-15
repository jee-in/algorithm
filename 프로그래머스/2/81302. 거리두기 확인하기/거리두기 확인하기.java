import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int k = 0; k < places.length; k++) {
            String[] room = places[k];
            int result = 1;
            
            r: for (int i = 0; i < 5; i++) {
                String row = room[i];
                for (int j = 0; j < 5; j++) {
                    char type = row.charAt(j);
                    if (type == 'P') {
                        if (!bfs(i, j, room)) {
                            result = 0;
                            break r;
                        }
                    }
                }
            }
            answer[k] = result;
        }
        
        return answer;
    }
    
    class Position {
        private int row;
        private int col;
        private int level;
        private boolean[][] visited;
        
        public Position(int row, int col, int level, boolean[][] visited) {
            this.row = row;
            this.col = col;
            this.level = level;
            this.visited = visited;
        }
        
        public int[] getPos() {
            return new int[]{row, col};
        }
        
        public int getLevel() {
            return level;
        }
        
        public boolean[][] getVisited() {
            return visited;
        }
    }
    
    private boolean bfs(int startRow, int startCol, String[] place) {
        Deque<Position> deque = new ArrayDeque<>();
        boolean[][] initialVisited = new boolean[5][5];
        initialVisited[startRow][startCol] = true;
        deque.offer(new Position(startRow, startCol, 1, initialVisited));
        
        while (!deque.isEmpty()) {
            Position cur = deque.poll();
            int[] curPos = cur.getPos();
            int curLevel = cur.getLevel();
            boolean[][] curVisited = cur.getVisited();
                        
            for (int i = 0; i < 3; i++) {
                int nrow = curPos[0] + DIRECTIONS[i][0];
                int ncol = curPos[1] + DIRECTIONS[i][1];
                int[] nextPos = new int[]{nrow, ncol};
                
                if (nrow < 0 || ncol < 0 || nrow >= 5 || ncol >= 5
                    || curVisited[nrow][ncol] == true
                   ) continue;
                
                char next = place[nrow].charAt(ncol);
                
                if (curLevel <= 2 && next == 'P') {
                    return false;
                }
                
                if (curLevel < 2 && next == 'O') {
                    boolean[][] nextVisited = curVisited;
                    nextVisited[nrow][ncol] = true;
                    deque.offer(new Position(nrow, ncol, curLevel + 1, nextVisited));
                }
            }            
        }   
        return true;
    }
}
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

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
    
    class Position implements Comparable<Position> {
        private int row;
        private int col;
        private int level;
        private Set<String> visited;
        
        public Position(int row, int col, int level, Set<String> visited) {
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
        
        public Set<String> getVisited() {
            return visited;
        }
        
        @Override
        public int compareTo(Position other) {
            if (Integer.compare(row, other.row) == 0 && Integer.compare(col, other.col) == 0) {
                return 0;
            }
            return -1;
        }
    }
    
    private boolean bfs(int startRow, int startCol, String[] place) {
        Deque<Position> deque = new ArrayDeque<>();
        Set<String> initialVisited = new HashSet<>();
        initialVisited.add(startRow + "" + startCol);
        deque.offer(new Position(startRow, startCol, 1, initialVisited));
        
        while (!deque.isEmpty()) {
            Position cur = deque.poll();
            int[] curPos = cur.getPos();
            int curLevel = cur.getLevel();
            Set<String> curVisited = cur.getVisited();
                        
            for (int i = 0; i < 3; i++) {
                int nrow = curPos[0] + DIRECTIONS[i][0];
                int ncol = curPos[1] + DIRECTIONS[i][1];
                int[] nextPos = new int[]{nrow, ncol};
                
                if (nrow < 0 || ncol < 0 || nrow >= 5 || ncol >= 5
                    || curVisited.contains(nrow + "" + ncol)
                   ) continue;
                
                char next = place[nrow].charAt(ncol);
                
                if (curLevel <= 2 && next == 'P') {
                    return false;
                }
                
                if (curLevel < 2 && next == 'O') {
                    Set<String> nextVisited = curVisited;
                    nextVisited.add(nrow + "" + ncol);
                    deque.offer(new Position(nrow, ncol, curLevel + 1, nextVisited));
                }
            }            
        }   
        return true;
    }
}
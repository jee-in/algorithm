import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

class Point {
    private final int row;
    private final int col;
    
    public Point (int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public int getRow() {
        return this.row;
    }
    
    public int getCol() {
        return this.col;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        
        Point point = (Point) o;
        return row == point.row && col == point.col;
    }

    @Override
    public int hashCode() {
        return 100 * row + col;
    }
}

class Solution {
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        char[][] containers = new char[storage.length][storage[0].length()];
        for (int i = 0; i < storage.length; i++) {
            containers[i] = storage[i].toCharArray();
        }
        
        for (String request : requests) {
            char target = request.charAt(0);
            if (request.length() == 1) {
                fork(containers, target);
            } else {
                crane(containers, target);
            }
        }
        
        for (int i = 0; i < containers.length; i++) {
            for (int j = 0; j < containers[0].length; j++) {
                if (containers[i][j] != '0') {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private void crane(char[][] containers, char target) {
        for (int i = 0; i < containers.length; i++) {
            for (int j = 0; j < containers[0].length; j++) {
                if (containers[i][j] == target) {
                    containers[i][j] = '0';
                }
            }
        }
    }
    
    private void fork(char[][] containers, char target) {
        boolean[][] isVisited = new boolean[containers.length][containers[0].length];
        
        for (int i = 0; i < containers.length; i++) {
            for (int j = 0; j < containers[0].length; j++) {
                if ((i == 0 || j == 0 || i == containers.length - 1 || j == containers[0].length - 1) && !isVisited[i][j]) {
                    bfs(containers, i, j, target, isVisited);
                }
            }
        }
        
        for (int i = 0; i < containers.length; i++) {
            for (int j = 0; j < containers[0].length; j++) {
                if (containers[i][j] == '1') {
                    containers[i][j] = '0';
                }
            }
        }
    }
    
    private void bfs(char[][] containers, int row, int col, char target, boolean[][] isVisited) {
        Deque<Point> deque = new ArrayDeque<>();
        deque.offer(new Point(row, col));

        while (!deque.isEmpty()) {
            Point p = deque.poll();
            int x = p.getRow();
            int y = p.getCol();

            if (x < 0 || y < 0 || x >= containers.length || y >= containers[0].length || isVisited[x][y]) {
                continue;
            }

            isVisited[x][y] = true;

            if (containers[x][y] == target) {
                containers[x][y] = '1';
                continue;
            }

            if (containers[x][y] == '0') {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];    

                    deque.offer(new Point(nx, ny));
                }
            }
        }
    }
}
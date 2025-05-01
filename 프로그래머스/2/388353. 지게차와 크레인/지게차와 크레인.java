import java.util.Arrays;

class Solution {
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;        
        char[][] containers = Arrays.stream(storage)
                                    .map(String::toCharArray)
                                    .toArray(char[][]::new);        

        Arrays.stream(requests)
            .forEach(request -> {
                if (request.length() == 1) {
                    fork(containers, request.charAt(0));
                } else {
                    crane(containers, request.charAt(0));
                }
            });
        
        // debugging
        Arrays.stream(containers)
            .map(Arrays::toString)
            .forEach(System.out::println);
        //
        
        for (int i = 0; i < containers.length; i++) {
            for (int j = 0; j < containers[i].length; j++) {
                if (containers[i][j] != '0') {
                    answer += 1;
                }
            }
        }
        
        return answer;
    }
    
    private void crane(char[][] containers, char target) {
        for (int i = 0; i < containers.length; i++) {
            for (int j = 0; j < containers[i].length; j++) {
                if (containers[i][j] == target) {
                    containers[i][j] = '0';
                }
            }
        }
    }
    
    private void fork(char[][] containers, char target) {
        boolean[][] isVisited = new boolean[containers.length][containers[0].length];
        
        for (int i = 0; i < containers.length; i++) {
            for (int j = 0; j < containers[i].length; j++) {
                if (i == 0 || j == 0 || i == containers.length - 1 || j == containers[0].length - 1) {
                    dfs(i, j, containers, isVisited, target);
                }
            }
        }
        
        for (int i = 0; i < containers.length; i++) {
          for (int j = 0; j < containers[i].length; j++) {
            if (containers[i][j] == '1') {
              containers[i][j] = '0';
            }
          }
        }
    }
    
    private void dfs(int row, int col, char[][] containers, boolean[][] isVisited, char target) {
        
        if (row < 0 || row >= containers.length || col < 0 || col >= containers[0].length) return;
        if (isVisited[row][col]) return;

        isVisited[row][col] = true;
        
        if (containers[row][col] == target) {
            containers[row][col] = '1';
            return;
        }
        
        if (containers[row][col] != '0') return;
        
        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            dfs(nx, ny, containers, isVisited, target);
        }
        
    }
}
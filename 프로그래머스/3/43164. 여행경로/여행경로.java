import java.util.*;

class Solution {
    String route = "";
    boolean[] visited;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

        dfs("ICN", "ICN", tickets, 0);
        return route.split(" ");
    }

    private void dfs(String current, String path, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            if (route.length() == 0) {
                route = path;
            }
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, depth + 1);
                visited[i] = false;
            }
        }
    }
}

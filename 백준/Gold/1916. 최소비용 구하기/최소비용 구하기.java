import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
  int node;
  int cost;

  public Edge(int node, int cost) {
    this.node = node;
    this.cost = cost;
  }

  public int compareTo(Edge other) {
    return Integer.compare(this.cost, other.cost); // 최소 비용 우선
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine().trim()); // 도시 개수
    int M = Integer.parseInt(br.readLine().trim()); // 버스 개수

    List<Edge>[] graph = new ArrayList[N + 1];
    for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

    for (int i = 0; i < M; i++) {
      int[] bus = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
      int u = bus[0], v = bus[1], w = bus[2];
      graph[u].add(new Edge(v, w));
    }

    int[] path = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    int start = path[0], end = path[1];

    int[] dist = dijkstra(N, start, graph);
    System.out.println(dist[end]);
  }

  static int[] dijkstra(int N, int start, List<Edge>[] graph) {
    int[] dist = new int[N + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.offer(new Edge(start, 0));

    while (!pq.isEmpty()) {
      Edge current = pq.poll();
      int now = current.node;
      int cost = current.cost;

      if (dist[now] < cost) continue;

      for (Edge next : graph[now]) {
        if (dist[next.node] > dist[now] + next.cost) {
          dist[next.node] = dist[now] + next.cost;
          pq.offer(new Edge(next.node, dist[next.node]));
        }
      }
    }

    return dist;
  }
}

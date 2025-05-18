import java.util.*;

class Cost {
    int depart;
    int destination;
    int cost;
    
    public Cost (int depart, int destination, int cost) {
        this.depart = depart;
        this.destination = destination;
        this.cost = cost;
    }
    
    public String toString() {
        return "Cost { destination: " + destination + ", cost: " + cost + " }";
    }
}

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n + 1];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }
        
        List<Cost> costList = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            int[] cost = costs[i];
            costList.add(new Cost(cost[0], cost[1], cost[2]));
        }
        
        costList.sort(Comparator.comparingInt(costInfo -> costInfo.cost));

        for (Cost costInfo : costList) {
            int a = costInfo.depart;
            int b = costInfo.destination;
            int cost = costInfo.cost;

            if (findParent(parent, a) != findParent(parent, b)) {
                union(parent, a, b);
                answer += cost;
            }
        }
        
        return answer;
    }
    
    static void union(int[] parents, int a, int b) {
        int parentA = findParent(parents, a);
        int parentB = findParent(parents, b);
        
        if (parentA < parentB) {
            parents[parentB] = parentA;
        } else {
            parents[parentA] = parentB;
        }
    }
    
    static int findParent(int[] parents, int x) {
        int p = parents[x];
        if (x == p) return p;
        
        return findParent(parents, p);
    }
}
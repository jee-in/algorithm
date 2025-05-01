import java.util.*;

import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
                
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (computers[i][j] == 1 && i != j) {
                    union(i, j, parent);
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            set.add(getParent(parent, i));
        }
        System.out.println(set);
        
        return set.size();
    }
    
    private void union(int a, int b, int[] parent) {
        int parentA = getParent(parent, a);
        int parentB = getParent(parent, b);
        
        if (parentA < parentB) {
            parent[parentB] = parentA;
        } else if (parentB < parentA) {
            parent[parentA] = parentB;
        }
    }
    
    private int getParent(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = getParent(parent, parent[index]);
        }
        return parent[index];
    }
}
import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        Map<Integer, List<int[]>> typeMap = new HashMap<>();
        for (int[] req : reqs) {
            typeMap.computeIfAbsent(req[2], key -> new ArrayList<>()).add(req);
        }

        List<Integer> typeList = new ArrayList<>(typeMap.keySet());
        List<int[]> combinations = generateCombinations(k, n);

        int minTotalWaiting = Integer.MAX_VALUE;

        for (int[] distribution : combinations) {
            int totalWaiting = 0;
            for (int i = 0; i < typeList.size(); i++) {
                int type = typeList.get(i);
                List<int[]> reqList = typeMap.get(type);
                totalWaiting += calculateWaitingTime(reqList, distribution[i]);
            }
            minTotalWaiting = Math.min(minTotalWaiting, totalWaiting);
        }

        return minTotalWaiting;
    }

    private int calculateWaitingTime(List<int[]> requests, int counselorCount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < counselorCount; i++) {
            pq.offer(0);
        }

        int totalWaiting = 0;

        for (int[] req : requests) {
            int start = req[0];
            int duration = req[1];

            int availableTime = pq.poll();
            int wait = Math.max(0, availableTime - start);
            totalWaiting += wait;

            pq.offer(Math.max(start, availableTime) + duration);
        }

        return totalWaiting;
    }

    private List<int[]> generateCombinations(int k, int n) {
        List<int[]> result = new ArrayList<>();
        dfs(new int[k], 0, n, result);
        return result;
    }

    private void dfs(int[] comb, int idx, int remaining, List<int[]> result) {
        if (idx == comb.length - 1) {
            if (remaining >= 1) {
                comb[idx] = remaining;
                result.add(Arrays.copyOf(comb, comb.length));
            }
            return;
        }

        for (int i = 1; i <= remaining - (comb.length - 1 - idx); i++) {
            comb[idx] = i;
            dfs(comb, idx + 1, remaining - i, result);
        }
    }
}

class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        PriorityQueue<Integer>[] g = new PriorityQueue[n];
        for (int i = 0; i < n; i++) {
            g[i] = new PriorityQueue<>(Comparator.comparingInt(a -> scores[a]));
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            g[a].offer(b);
            g[b].offer(a);
            if(g[a].size() > 3) g[a].poll();
            if(g[b].size() > 3) g[b].poll();
        }
        int res = -1;
        for (int[] e : edges) {
            for(int i : g[e[0]]){
                for(int j : g[e[1]]){
                    if(i != j && i != e[1] && j != e[0]){
                        res = Math.max(res, scores[i] + scores[j] + scores[e[0]] + scores[e[1]]);
                    }
                }
            }
        }
        return res;
    }
}


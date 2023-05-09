class Solution {
    public long maxScore(int[][] edges) {
        int n = edges.length;
        LinkedList<int[]>[] g = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        for (int i = 1; i < n ; i++) {
            int parent = edges[i][0];
            int weight = edges[i][1];
            g[parent].add(new int[]{i, weight});
        }
        long[] res = dfs(g, 0);
        return Math.max(res[0], res[1]);
    }

    public long[] dfs(LinkedList<int[]>[] g, int i){
        long best_i = 0, without_i = 0;
        for(int[] e : g[i]){
            int v = e[0], w = e[1];
            long[] sub = dfs(g, v);
            long with_j = sub[0], without_j = sub[1];
            best_i = Math.max(best_i, Math.max(0, w) + without_j - with_j);
            without_i += Math.max(with_j, without_j);
        }
        return new long[]{best_i + without_i, without_i};
    }
}
class Solution {
    int res = 0;
    public int numberOfPaths(int n, int[][] corridors) {
        HashSet<Integer>[] graph = new HashSet[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] c : corridors) {
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]);
        }
        for (int i = 0; i < n; i++) {
            dfs(graph, i, i, 1);
        }
        return res;
    }

    private void dfs(HashSet<Integer>[] graph, int curr, int start, int count) {
        if(count == 3){
            if(graph[curr].contains(start)) res++;
            return;
        }
        for(int next : graph[curr]){
            if(next < curr) continue;
            dfs(graph, next, start, count + 1);
        }
    }
}
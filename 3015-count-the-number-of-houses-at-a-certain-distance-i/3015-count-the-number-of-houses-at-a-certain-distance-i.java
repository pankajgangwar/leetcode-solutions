class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[] res = new int[n];
        List<Integer>[] adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i < n; i++){
            adj[i].add(i+1);
            adj[i+1].add(i);
        }
        adj[x].add(y);
        adj[y].add(x);

        for (int i = 1; i <= n; i++) {
            runBfs(i, res, adj );
        }
        return res;
    }

    public void runBfs(int source, int[] ans, List<Integer>[] adj){
        int n = ans.length;
        Queue<Integer> bfs = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[source] = true;
        bfs.offer(source);
        int level = 0;
        while (!bfs.isEmpty()){
            int size = bfs.size();
            while (size-- > 0){
                int u = bfs.poll();
                for(int v : adj[u]){
                    if(!visited[v]){
                        visited[v] = true;
                        bfs.offer(v);
                        ans[level] += 1;
                    }
                }
            }
            level++;
        }
    }
}
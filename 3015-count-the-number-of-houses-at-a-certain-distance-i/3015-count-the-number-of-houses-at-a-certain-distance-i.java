class Solution {
    
    public int[] countOfPairs(int n, int x, int y) {
        return floydWarshall(n, x, y);
    }
    public int[] bfsSol(int n, int x, int y) {
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
    
     public int[] floydWarshall(int n, int x, int y) {
        int[][] dist = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
            if(i < n){
                dist[i][i+1] = 1;
            }
            if(i > 0){
                dist[i][i-1] = 1;
            }
        }
        dist[x][y] = dist[y][x] = 1;

        for(int k = 1; k <= n; k++){
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n ; j++) {
                    if(dist[i][k] != Integer.MAX_VALUE && 
                         dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= n ; j++) {
                if(dist[i][j] != Integer.MAX_VALUE && (i != j)){
                    countMap.put(dist[i][j], countMap.getOrDefault(dist[i][j], 0) + 1);
                }
            }
        }

        int[] res = new int[n];
        for (int k = 1; k <= n ; k++) {
            res[k-1] = countMap.getOrDefault(k, 0);
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
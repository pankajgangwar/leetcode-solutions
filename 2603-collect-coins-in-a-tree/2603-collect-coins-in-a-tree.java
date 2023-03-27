class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        HashSet<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        for(int[] e : edges){
            int src = e[0];
            int dst = e[1];
            graph[src].add(dst);
            graph[dst].add(src);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int u = i;
            while (graph[u].size() == 1 && coins[u] == 0){
                int v = graph[u].iterator().next();
                graph[u].remove(v);
                graph[v].remove(u);
                u = v;
            }
            if(graph[u].size() == 1){
                q.offer(u);
            }
        }
        for (int i = 0; i < 2; i++) {
            int size = q.size();
            while (size-- > 0){
                int leaf = q.poll();
                if(graph[leaf].size() == 1){
                    int v = graph[leaf].iterator().next();
                    graph[leaf].remove(v);
                    graph[v].remove(leaf);
                    if(graph[v].size() == 1){
                        q.offer(v);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += graph[i].size();
        }
        return ans;
    }
}
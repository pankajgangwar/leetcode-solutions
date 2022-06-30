class Solution {
    // https://cp-algorithms.com/graph/finding-cycle.html
    public int[] distanceToCycle(int n, int[][] edges) {
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        int[] color = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int u = 0; u < n; u++) {
            if(color[u] == 0 && dfs(-1, u, color, parent, graph)){
                break;
            }
        }
        Set<Integer> cycle = new HashSet<>();
        cycle.add(cycle_start);
        for (int v = cycle_end; v != cycle_start ; v = parent[v]) {
            cycle.add(v);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        bfs(graph, dist, cycle);
        return dist;
    }

    int cycle_end = -1, cycle_start = -1;
    public boolean dfs(int parentNode, int u, int[] color, int[] parent, LinkedList<Integer>[] adj) {
        color[u] = 1;
        for (int v : adj[u]) {
            if(parentNode == v) continue;
            if (color[v] == 0) {
                parent[v] = u;
                if (dfs(u, v, color, parent, adj))
                    return true;
            } else if (color[v] == 1) {
                cycle_end = u;
                cycle_start = v;
                return true;
            }
        }
        color[u] = 2;
        return false;
    }
    
    

    public void bfs(LinkedList<Integer>[] g, int[] dist, Set<Integer> cycle){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        Iterator<Integer> it = cycle.iterator();
        while (it.hasNext()){
            int u = it.next();
            q.offer(u);
            visited.add(u);
        }
        int currDis = 0;
        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0){
                int u = q.poll();
                dist[u] = Math.min(dist[u], currDis);
                for(int v : g[u]){
                    if(cycle.contains(v))continue;
                    if(visited.contains(v))continue;
                    q.offer(v);
                    visited.add(v);
                }
            }
            currDis++;
        }
    }
}
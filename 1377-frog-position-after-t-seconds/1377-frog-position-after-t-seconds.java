class Solution {
    
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        double[] prob = new double[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        prob[1] = 1;
        while (!queue.isEmpty() && t-- > 0){
            int size = queue.size();
            while (size-- > 0){
                int u = queue.poll();
                visited[u] = true;
                int total = 0;

                for(int v : graph[u]) if(!visited[v]) total++;
                
                for(int v : graph[u]){
                    if(visited[v]) continue;
                    prob[v] = prob[u] / total;
                    queue.offer(v);
                }
                if(total > 0) prob[u] = 0;
            }
        }
        return prob[target];
    }
}
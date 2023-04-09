class Solution {
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
       return probabilityWithBellmanFord(n, edges, succProb, start, end);
       // return probabilityWithFloydWarshall(n, edges, succProb, start, end);
        //return probabilityWithDijkstra(n, edges, succProb, start, end);
    }

    public double probabilityWithBellmanFord(int n, int[][] edges, double[] succProb, int start, int end){
        HashMap<Integer, List<int[]>> g = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            g.computeIfAbsent(b, l -> new ArrayList<>()).add(new int[]{a, i});
            g.computeIfAbsent(a, l -> new ArrayList<>()).add(new int[]{b, i});
        }

        double[] probs = new double[n];
        probs[start] = 1d;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int[] a : g.getOrDefault(cur, new ArrayList<>())){
                int neigh = a[0];
                int idx = a[1];
                if(probs[cur] * succProb[idx] > probs[neigh]){
                    probs[neigh] = probs[cur] * succProb[idx];
                    q.offer(neigh);
                }
            }
        }
        return probs[end];   
    }

    public double probabilityWithFloydWarshall(int n, int[][] edges, double[] succProb, int start, int end){
        //TLE
        double[][] probs = new double[n][n];

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            probs[a][b] = probs[b][a] = succProb[i];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    probs[i][j] = Math.max(probs[i][j], probs[i][k] * probs[k][j]);
                }
            }
        }
        return probs[start][end];
    }
    
    public double probabilityWithDijkstra(int n, int[][] edges, double[] succProb, int start, int end){
        // Using Dijkstra's Algorithm
        HashMap<Integer, HashMap<Integer, Double>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];
            graph.putIfAbsent(src, new HashMap<Integer, Double>());
            graph.putIfAbsent(dst, new HashMap<Integer, Double>());
            graph.get(src).put(dst, succProb[i]);
            graph.get(dst).put(src, succProb[i]);
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> -Double.compare(a[0], b[0]));

        pq.offer(new double[]{1, start});
        boolean[] visited = new boolean[n];
        while (!pq.isEmpty()){
            double[]curr = pq.poll();
            int curr_src = (int)curr[1];
            if(visited[curr_src]) continue;
            visited[curr_src] = true;
            if(curr_src == end){
                return curr[0];
            }
            HashMap<Integer, Double> adj = graph.getOrDefault(curr_src, new HashMap<Integer, Double>());
            for(Integer next_src : adj.keySet()){
                double prob = adj.get(next_src) * curr[0];
                pq.offer(new double[]{prob, next_src});
            }
        }
        return 0d;
    }
    
    
}
class Solution {
    public int maximumCost(int n, int[][] highways, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < highways.length; i++){
            int u = highways[i][0], v = highways[i][1], c = highways[i][2];
            graph[u].add(new int[]{v, c});
            graph[v].add(new int[]{u, c});
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> -a[1] + b[1]);
        int max = -1;
        for(int i = 0; i < n; i++){
            boolean[] visited = new boolean[n];
            maxHeap.clear();
            maxHeap.offer(new int[]{i, 0, 0});
            while (!maxHeap.isEmpty()){
                int[] curr = maxHeap.poll();
                int currCost = curr[1], currK = curr[2], u = curr[0];
                visited[u] = true;
                if(currK > k )continue;
                if(currK == k) {
                    max = Math.max(max, currCost);
                    break;
                }
                for(int[] adj : graph[u]){
                    int v = adj[0], adjCost = adj[1];
                    if(visited[v]) continue;
                    maxHeap.offer(new int[]{v, adjCost + currCost, currK + 1});
                }
            }
        }
        return max;
    }
}
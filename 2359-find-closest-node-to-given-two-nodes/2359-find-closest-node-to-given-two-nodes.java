class Solution {
     public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] distA = new int[n];
        Arrays.fill(distA, Integer.MAX_VALUE);

        int[] distB = new int[n];
        Arrays.fill(distB, Integer.MAX_VALUE);
        bfs(node1, distA, edges);
        bfs(node2, distB, edges);

        int node = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(distA[i] == Integer.MAX_VALUE || distB[i] == Integer.MAX_VALUE) continue;
            if(res > Math.max(distA[i] , distB[i])){
                res = Math.max(distA[i], distB[i]);
                node = i;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : node;
    }

    public void bfs(int src, int[] dist, int[] edge){
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        HashSet<Integer> visited = new HashSet<>();
        visited.add(src);
        dist[src] = 0;

        while (!q.isEmpty()){
            int next = q.poll();
            int adj = edge[next];
            if(adj == -1 || visited.contains(adj)) {
                continue;
            }
            dist[adj] = dist[next] + 1;
            visited.add(adj);
            q.offer(adj);
        }
    }
}
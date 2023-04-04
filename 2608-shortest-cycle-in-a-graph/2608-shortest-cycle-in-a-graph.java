class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) graph.putIfAbsent(i, new HashSet<>());
        for(int[] e : edges){
            int src = e[0];
            int dst = e[1];
            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            ArrayDeque<Integer> q = new ArrayDeque<>();
            int src = i;
            q.offer(src);

            int[] distance = new int[n];
            int[] parent = new int[n];

            Arrays.fill(distance, Integer.MAX_VALUE);
            Arrays.fill(parent, -1);

            distance[src] = 0;
            while (!q.isEmpty()){
                int size = q.size();
                while (size-- > 0){
                    int par = q.poll();
                    for(int child : graph.get(par)){
                        if(distance[child] == Integer.MAX_VALUE){
                            distance[child] = distance[par] + 1;
                            q.offer(child);
                            parent[child] = par;
                        }else if(parent[par] != child && parent[child] != par){
                            ans = Math.min(ans, distance[par] + distance[child] + 1);
                        }
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
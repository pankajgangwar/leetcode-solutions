class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[edges.length + 2];
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
            indegree[v]++;
            indegree[u]++;
        }
        Queue<Integer> bfs = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 1; i <= edges.length + 1; i++) {
            if(indegree[i] <= 1){
                bfs.offer(i);
                visited.add(i);
            }
        }
        while (!bfs.isEmpty()){
            int size = bfs.size();
            if(size == 1){
                return bfs.poll();
            }
            while (size-- > 0){
                int u = bfs.poll();
                for(int v : graph.getOrDefault(u, new ArrayList<>())){
                    if(visited.contains(v)) continue;
                    visited.add(v);
                    bfs.offer(v);
                }
            }
        }
        return -1;
    }
}
class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int[]a = bombs[i];
            int x1 = a[0];
            int y1 = a[1];
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                int[] b = bombs[j];
                int x2 = b[0];
                int y2 = b[1];
                graph.putIfAbsent(i, new LinkedList<>());
                
                long r2 = (long) a[2] * a[2];
                long dis = (long) Math.pow(x2 - x1, 2) + (long)Math.pow(y2 - y1, 2);
                if(dis <= r2){
                    graph.get(i).add(j);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n && max < n; i++) {
            int count = dfs(i, new HashSet<>(), graph);
            max = Math.max(max, count);
        }
        return max;
    }

    private int dfs(int src, HashSet<Integer> visited, HashMap<Integer, LinkedList<Integer>> graph) {
        if(visited.contains(src)) return 0;
        visited.add(src);
        int count = 1;
        for(int adj : graph.getOrDefault(src, new LinkedList<>())){
            count += dfs(adj, visited, graph);
        }
        return count;
    }
}
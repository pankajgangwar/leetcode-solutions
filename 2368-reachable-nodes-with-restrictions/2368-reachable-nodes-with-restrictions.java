class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        LinkedList<Integer>[] g = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        for(int[] e : edges){
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        HashSet<Integer> restrict = new HashSet<>();
        for(int node : restricted){
            restrict.add(node);
        }
        HashSet<Integer> visited = new HashSet<>();
        return dfs(g, 0, restrict, visited);
    }

    private int dfs(LinkedList<Integer>[] g, int src, HashSet<Integer> restrict, HashSet<Integer> visited) {
        if(visited.contains(src) || restrict.contains(src)) return 0;
        visited.add(src);
        int count = 1;
        for(int adj : g[src]){
            count += dfs(g, adj, restrict, visited);
        }
        return count;
    }
}
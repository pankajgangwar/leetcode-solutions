class Solution {
    public int[] closestNode(int n, int[][] edges, int[][] query) {
        int[] ans = new int[query.length];
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 0; i < query.length; i++) {
            HashSet<Integer> path = new HashSet<>();
            findPath(query[i][0], query[i][1], -1, path, graph);
            for(int node : path){
                if(nodeCanReach(node, query[i][2], -1, path, graph)){
                    ans[i] = node;
                    break;
                }
            }
        }
        return ans;
    }

    private boolean nodeCanReach(int src, int target, int parent, HashSet<Integer> path, LinkedList<Integer>[] graph) {
        if(src == target) {
            return true;
        }
        for(int adj : graph[src]){
            if(adj != parent && !path.contains(adj) && nodeCanReach(adj, target, src, path, graph)){
                return true;
            }
        }
        return false;
    }

    private boolean findPath(int src, int dest, int parent, HashSet<Integer> path, LinkedList<Integer>[] graph) {
        if(src == dest){
            path.add(src);
            return true;
        }
        for(int adj : graph[src]){
            if(adj != parent && findPath(adj, dest, src, path, graph)){
                path.add(src);
                return true;
            }
        }
        return false;
    }
}
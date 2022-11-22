class Solution {
    
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length;
        subTree = new int[n + 1];
        LinkedList<Integer>[] graph = new LinkedList[n + 1];
        st = seats;
        for (int i = 0; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for(int[] r : roads){
            int u = r[0];
            int v = r[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        dfs(0, -1, graph);
        return ans;
    }

    int[] subTree;
    long ans;
    int st;
    public void dfs(int src, int parent, LinkedList<Integer>[] graph){
        subTree[src] = 1;
        for(int adj : graph[src]){
            if(adj != parent){
                dfs(adj, src, graph);
                ans += (subTree[adj] + st - 1) / st;
                subTree[src] += subTree[adj];
            }
        }
    }
}
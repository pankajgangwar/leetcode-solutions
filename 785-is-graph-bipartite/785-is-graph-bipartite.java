class Solution {
    public boolean isBipartite(int[][] graph) {
        return isBipartiteUnionFind(graph);
        //return isBipartiteBFS(graph);
    }
    public boolean isBipartiteBFS(int[][] graph) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;
            color[i] = 1;

            Queue<Integer> bfs = new LinkedList<>();
            bfs.offer(i);

            while (!bfs.isEmpty()) {
                int curr = bfs.poll();
                for (int adj : graph[curr]) {
                    if (color[adj] == 0) {
                        color[adj] = -color[curr];
                        bfs.offer(adj);
                    } else if (color[adj] != -color[curr]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isBipartiteUnionFind(int[][] graph) {
        int[] root = new int[graph.length];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }

        for(int i = 0; i < graph.length; i++){

            int[] adj = graph[i];

            for(int j = 0; j < adj.length;  j++){

                int xRoot = findPathComparession(i, root);
                int yRoot = findPathComparession(adj[j], root);
                if(xRoot != yRoot){
                    root[findPathComparession(adj[0], root)] = yRoot;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    
    public int find(int i, int[] parent) {
        if (parent[i] == i) {
            return parent[i];
        }
        parent[i] = find(parent[i], parent);
        return parent[i];
    }

    public int findPathComparession(int x, int[] root){
        while(x != root[x]){
            root[x] = root[root[x]];
            x = root[x];
        }
        return x;
    }
}
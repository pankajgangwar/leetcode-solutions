class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        TreeMap<Integer, ArrayList<Integer>> sameValMap = new TreeMap<>();
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
            sameValMap.putIfAbsent(vals[i], new ArrayList<>());
            sameValMap.get(vals[i]).add(i);
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if(vals[u] >= vals[v]){
                graph[u].add(v);
            }else if(vals[v] >= vals[u]){
                graph[v].add(u);
            }
        }
        UnionFind unionFind = new UnionFind(n);
        int goodPaths = 0;
        for(Map.Entry<Integer, ArrayList<Integer>> e : sameValMap.entrySet()){
            for(int node : e.getValue()){
                for(int adj : graph[node]){
                    unionFind.union(node, adj);
                }
            }
            HashMap<Integer, Integer> groups = new HashMap<>();
            for(int node : e.getValue()){
                int root = unionFind.find(node);
                groups.put(root, groups.getOrDefault(root, 0) + 1);
            }
            goodPaths += e.getValue().size();
            for(Map.Entry<Integer, Integer> g : groups.entrySet()){
                int size = g.getValue();
                int res = (size * (size - 1)) / 2;
                goodPaths += res;
            }
        }
        return goodPaths;
    }
    
    public class UnionFind {
    private int count = 0;
    private int[] parent, rank;
    public int[] size;
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int a, int b) {
        return (find(a) == find(b));
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (rank[rootQ] > rank[rootP]) {
            parent[rootP] = rootQ; // p points to q
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP; // q points to p
            size[rootP] += size[rootQ];
            if (rank[rootP] == rank[rootQ]) {
                rank[rootP]++;
            }
        }
        count--;
    }
    public int getDisjointSets() {
        return count;
    }
}

}
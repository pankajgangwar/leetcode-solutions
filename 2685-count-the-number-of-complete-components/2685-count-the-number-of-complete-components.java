class Solution {
    public int countCompleteComponents(int n, int[][] connections) {
        LinkedList<Integer>[] g = new LinkedList[n];
        for(int i = 0; i < n; i++) g[i] = new LinkedList<>();
        UnionFind find = new UnionFind(n);
        for(int[] c : connections){
            int u = c[0], v = c[1];
            g[u].add(v);
            g[v].add(u);
            find.union(u, v);
        }
        int connectionNeeded = 0;
        for (int i = 0; i < n; i++) {
            if(find.parent[i] == i && dfs(find.size[i], i, g, new HashSet<>())){
                connectionNeeded++;
            }
        }
        return connectionNeeded;
    }
    public boolean dfs(int c, int u, LinkedList<Integer>[] g, HashSet<Integer> visited){
        if(g[u].size() != c - 1) return false;
        if(visited.contains(u)) return true;
        visited.add(u);
        for(int v : g[u]){
            if(!dfs(c, v, g, visited)) return false;
        }
        return true;
    }
}

public class UnionFind {
    public int count = 0;
    public int[] parent, rank;
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
class Solution {
    public int longestCycle(int[] edges) {
        int[] ret = detectCycles(edges);
        int max = -1;
        for(int v : ret) max = Math.max(max, v);
        return max;
    }

    public int[] detectCycles(int[] edges){
        int n = edges.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            if(edges[i] >= 0){
                unionFind.union(i, edges[i]);
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        int p = 0;
        int[] ret = new int[n];
        outer:
        for (int i = 0; i < n; i++) {
            if(!visited.contains(unionFind.find(i))){
                visited.add(unionFind.find(i));
                int pow = 1, cycleLen = 1;
                if(edges[i] < 0) continue;
                int tortoise = i;
                int hare = edges[i];
                while (tortoise != hare){
                    if(pow == cycleLen){
                        tortoise = hare;
                        pow <<= 1;
                        cycleLen = 0;
                    }
                    hare = edges[hare];
                    if(hare < 0) continue outer;
                    cycleLen++;
                }
                if(cycleLen > 0){
                    ret[p++] = cycleLen;
                }
            }
        }
        return Arrays.copyOf(ret, p);
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
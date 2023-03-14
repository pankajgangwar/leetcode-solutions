class LUPrefix {
        int n;
        int[] videos;
        int idx = 0;
        UnionFind uf;
        public LUPrefix(int n) {
            this.n = n;
            videos = new int[n + 1];
            uf = new UnionFind(n + 1);
        }

        public void upload(int video) {
            videos[video] = video;
            if(video - 1 >= 1 && videos[video - 1] != 0) {
                uf.union(videos[video - 1], video);
            }
            if(video + 1 <= n && videos[video + 1] != 0){
                uf.union(videos[video + 1], video);
            }
            if(uf.isConnected(1, video)){
                idx = Math.max(idx, uf.size[uf.find(1)]);
            }
        }

        public int longest() {
            return idx;
        }
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

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */
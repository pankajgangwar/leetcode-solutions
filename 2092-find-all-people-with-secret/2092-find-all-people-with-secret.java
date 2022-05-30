class Solution {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));
        UnionFind unionFind = new UnionFind(n);
        unionFind.union(0, firstPerson);
        int m = meetings.length;
        List<Integer> ppl = new ArrayList<>();
        for (int i = 0; i < m; ) {
            ppl.clear();
            int time = meetings[i][2];
            while (i < m && time == meetings[i][2]){
                int p1 = meetings[i][0];
                int p2 = meetings[i][1];
                unionFind.union(p1, p2);
                ppl.add(p1);
                ppl.add(p2);
                ++i;
            }
            for(int p : ppl){
                if(!unionFind.isConnected(p, 0)) unionFind.reset(p);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (unionFind.isConnected(i, 0)) res.add(i);
        }
        return res;
    }

    class UnionFind {
        int n;
        int[] rank;
        int[] parent;
        int[] size;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            Arrays.fill(size, 1);
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public boolean isConnected(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;
                }
            }
        }
        public void reset(int p){
            parent[p] = p;
        }
    }
}

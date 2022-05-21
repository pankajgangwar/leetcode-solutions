class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length) return false;
        HashSet<String> unique = new HashSet<>();
        for(List<String> list : similarPairs){
            String a = list.get(0);
            String b = list.get(1);
            unique.add(a);
            unique.add(b);
        }
        int n = unique.size();
        List<String> pairs = new ArrayList<>();
        for (String s : unique) {
            pairs.add(s);
        }
        UnionFind uf = new UnionFind(n);
        for(List<String> list : similarPairs){
            String a = list.get(0);
            String b = list.get(1);
            int p = pairs.indexOf(a);
            int q = pairs.indexOf(b);
            if(uf.find(p) != uf.find(q)){
                uf.union(p, q);
            }
        }
        for (int i = 0; i < sentence1.length; i++) {
            String a = sentence1[i];
            String b = sentence2[i];
            if(!a.equals(b)){
                int p = pairs.indexOf(a);
                int q = pairs.indexOf(b);
                if(p < 0 || q < 0) return false;
                boolean isPair = uf.isConnected(p,q);
                if(!isPair){
                    return false;
                }
            }
        }
        return true;
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
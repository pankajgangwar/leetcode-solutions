class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = 26;
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        UnionFind unionFind = new UnionFind(n);
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            unionFind.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
            int r1 = unionFind.find(s1.charAt(i) - 'a');
            int r2 = unionFind.find(s2.charAt(i) - 'a');
            map.putIfAbsent(r1, new PriorityQueue<>());
            map.get(r1).add(s1.charAt(i));
            map.get(r1).add(s2.charAt(i));
        }
        StringBuilder sb = new StringBuilder();

        for(char ch : baseStr.toCharArray()){
            int child = ch - 'a';
            int root = unionFind.find(child);
            PriorityQueue<Character> pq = map.getOrDefault(root, new PriorityQueue<>());
            if(!pq.isEmpty() && pq.peek() <= ch){
                sb.append(pq.peek());
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
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
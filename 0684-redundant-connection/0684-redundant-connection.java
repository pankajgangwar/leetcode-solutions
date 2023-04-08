class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uFind = new UnionFind(n);
        for(int[] edge : edges){
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            int a_root = uFind.findParent(a);
            int b_root = uFind.findParent(b);
            if(a_root != b_root){
               uFind.union(a,b); 
            }else{
                return edge;
            }
        }
        return new int[]{0, 0};
    }
}


class UnionFind {
    
    int[] parent;
    int[] rank;
    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(rank, 1);
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }
    
    public int findParent(int i){
        while(parent[i] != i){
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
    
    public void union(int i, int j){
        int rootP = findParent(i);
        int rootQ = findParent(j);
        if (rank[rootQ] > rank[rootP]) {
            parent[rootP] = rootQ; // p points to q
        } else {
            parent[rootQ] = rootP; // q points to p
            if (rank[rootP] == rank[rootQ]) {
                rank[rootP]++;
            }
        }
    }
}
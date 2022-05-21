class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for(int[] edge : edges){
            int xParent = findParent(parent, edge[0]);
            int yParent = findParent(parent, edge[1]);
            if(xParent == yParent){
                return false;
            }

            //Union of these two parents to single disjoint subsets
            //union(parent, xParent, yParent);
            parent[xParent] = yParent;
        }

        return true;
    }

    public void union(int[] parent, int src, int dst){
        int xRoot = findParent(parent, src);
        int yRoot = findParent(parent, dst);
        parent[xRoot] = yRoot;
    }

    public int findParent(int[] parent, int src){
        if(parent[src] == -1)
            return src;

        return findParent(parent, parent[src]);
    }
}
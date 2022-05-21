class Solution {
    /* 
       Similar to https://leetcode.com/problems/smallest-string-with-swaps/
    */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> mapEmailWithId = new HashMap<>();
        HashMap<String, String> mapWithNames = new HashMap<>();
        
        UnionFind unionFind = new UnionFind();
        int id = 0;
        for(List<String> account : accounts){
            for(int i = 1; i < account.size(); i++){
                String email = account.get(i);
                mapWithNames.put(email, account.get(0));
                
                if(!mapEmailWithId.containsKey(email)){
                    mapEmailWithId.put(email, id++);
                }
                
                unionFind.union(mapEmailWithId.get(account.get(1)), mapEmailWithId.get(email));
            }
        }
        
        Map<Integer, ArrayList<String>> mapWithHead = new HashMap<>();
        
        for(String email : mapWithNames.keySet()){
            int root = unionFind.find(mapEmailWithId.get(email));
            mapWithHead.putIfAbsent(root, new ArrayList<>());
            mapWithHead.get(root).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<String>> entry : mapWithHead.entrySet()){
            ArrayList<String> accountList = entry.getValue();
            String name = mapWithNames.get(accountList.get(0));
            List<String> currlist = new ArrayList<>();
            Collections.sort(accountList);
            currlist.add(name);
            currlist.addAll(accountList);
            res.add(currlist);
        }
        return res;
    }

     class UnionFind {
        private int count = 0;
        private int[] parent, rank;
         int n = 10001;
         public UnionFind() {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
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
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;
                }
            }
            count--;
        }
        
        public int count() {
            return count;
        }
    }

}
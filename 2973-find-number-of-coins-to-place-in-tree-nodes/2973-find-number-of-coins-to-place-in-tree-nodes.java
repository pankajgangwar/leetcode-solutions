class Solution {
   
    public long[] placedCoins(int[][] edges, int[] cost) {
        int n = cost.length;
        res = new long[cost.length];
        HashMap<Integer, HashSet<Integer>> g = new HashMap<>();
        for(int[] e : edges){
            g.putIfAbsent(e[0], new HashSet<>());
            g.get(e[0]).add(e[1]);

            g.putIfAbsent(e[1], new HashSet<>());
            g.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(0, g, cost, -1, visited);
        return res;
    }

    long[] res;
    public List<Integer> dfs(int src, HashMap<Integer, HashSet<Integer>> g,
                                      int[] cost, int parent, boolean[]visited){
        List<Integer> temp = new ArrayList<>();
        temp.add(cost[src]);
        visited[src] = true;
        for(int adj : g.getOrDefault(src, new HashSet<>())){
            if(adj != parent && !visited[adj]){
                temp.addAll(dfs(adj, g, cost, src, visited));
            }
        }
        Collections.sort(temp);
        int n = temp.size();
        if(n >= 3){
            long left = (long) temp.get(0) * (long)temp.get(1);
            long right = (long) temp.get(n-3) * (long)temp.get(n-2);
            res[src] = Math.max(0, Math.max(left, right) * temp.get(n-1));
        }else{
            res[src] = 1;
        }
        if(n <= 5) return temp;
        List<Integer> ans = new ArrayList<>();
        ans.add(temp.get(0));
        ans.add(temp.get(1));
        ans.add(temp.get(n-3));
        ans.add(temp.get(n-2));
        ans.add(temp.get(n-1));
        return ans;
        //return new ArrayList<>(Arrays.asList(temp.get(0), temp.get(1), temp.get(n - 3), temp.get(n - 2), temp.get(n - 1)));
    }
   
}
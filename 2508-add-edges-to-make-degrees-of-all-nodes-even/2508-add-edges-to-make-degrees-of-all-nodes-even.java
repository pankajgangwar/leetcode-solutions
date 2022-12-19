class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int[] deg = new int[n + 1];
        List<Integer> odd = new ArrayList<>();
        for(List<Integer> ed : edges){
            int u = ed.get(0);
            int v = ed.get(1);
            graph.putIfAbsent(u, new HashSet<>());
            graph.putIfAbsent(v, new HashSet<>());
            graph.get(u).add(v);
            graph.get(v).add(u);

            deg[u]++;
            deg[v]++;
        }
        for (int i = 1; i <= n; i++) {
            if(deg[i] % 2 != 0){
                odd.add(i);
            }
        }
        if(odd.size() > 4 || odd.size()%2 != 0) return false;
        if(odd.isEmpty()) return true;
        if(odd.size() == 4){
            int a = odd.get(0), b = odd.get(1), c = odd.get(2), d = odd.get(3);
            // a ---- b, c ---- d
            boolean f1 = (!graph.get(a).contains(b) && !graph.get(c).contains(d));
            boolean f2 = (!graph.get(a).contains(c) && !graph.get(b).contains(d));
            boolean f3 = (!graph.get(a).contains(d) && !graph.get(b).contains(c));
            if(f1 || f2 || f3 ) return true;
            return false;
        }else{
            int a = odd.get(0), b = odd.get(1);
            boolean f1 = (!graph.get(a).contains(b) && !graph.get(b).contains(a));
            if(f1) return true;
            for (int i = 1; i <= n; i++) {
                if(!graph.get(a).contains(i) && (!graph.get(b).contains(i))) {
                    return true;
                }
            }
            return false;
        }
    }
}
class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rId = topologicalSort(k, rowConditions);
        List<Integer> cId = topologicalSort(k, colConditions);
        if(rId.isEmpty() || cId.isEmpty()) return new int[0][0];
        int[][] res = new int[k][k];
        for (int i = 1; i <= k; i++) {
            res[rId.get(i-1)][cId.get(i-1)] = i;
        }
        return res;
    }

    public List<Integer> topologicalSort(int k, int[][] conditions){
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[k + 1];
        List<Integer> sorted = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
        for(int[] c : conditions){
            int u = c[0];
            int v = c[1];
            g.putIfAbsent(u, new ArrayList<>());
            g.get(u).add(v);
            indegree[v]++;
        }
        for (int i = 1; i <= k ; i++) {
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0){
                int c = q.poll();
                sorted.add(c);
                for(int adj : g.getOrDefault(c, new ArrayList<>())){
                    if(--indegree[adj] == 0){
                        q.offer(adj);
                    }
                }
            }
        }
        if(sorted.size() != k) return new ArrayList<>();
        List<int[]> id = new ArrayList<>();
        for (int i = 0; i < k; i++) id.add(new int[]{i, sorted.get(i)});
        id.sort((a,b) -> (a[1] - b[1]));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < id.size(); i++) {
            result.add(id.get(i)[0]);
        }
        return result;
    }
}
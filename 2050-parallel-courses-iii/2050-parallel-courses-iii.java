class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] indegree = new int[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] re : relations){
            int u = re[0] - 1;
            int v = re[1] - 1;
            indegree[v]++;
            map.putIfAbsent(u, new ArrayList<>());
            map.get(u).add(v);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] completionTime = new int[n];
        for (int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
                completionTime[i] = time[i];
            }
        }
        while (!q.isEmpty()){
            int u = q.poll();
            for(int v : map.getOrDefault(u, new ArrayList<>())){
                completionTime[v] = Math.max(completionTime[v], completionTime[u] + time[v]);
                if(--indegree[v] == 0){
                    q.offer(v);
                }
            }
        }
        return Arrays.stream(completionTime).max().getAsInt();
    }
}
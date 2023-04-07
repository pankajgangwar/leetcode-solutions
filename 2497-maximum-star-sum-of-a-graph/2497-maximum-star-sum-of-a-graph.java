class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
        List<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        int max = Integer.MIN_VALUE;
        for (int u = 0; u < n; u++) {
            pq.clear();
            for(int v : graph[u]){
                pq.add(vals[v]);
            }
            int curr = vals[u];
            int temp = k;
            while (!pq.isEmpty() && temp-- > 0){
                curr = Math.max(curr, curr + pq.poll());
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}
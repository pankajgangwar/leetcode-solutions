class Solution {
    public int componentValue(int[] nums, int[][] edges) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        LinkedList<Integer>[] graph = new LinkedList[n];
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
            degree[u]++;
            degree[v]++;
        }
        for (int i = n; i >= 1 ; i--) {
            if(sum % i == 0 && bfs(sum / i, graph, degree, nums)){
                return i-1;
            }
        }
        return 0;
    }

    private boolean bfs(int target, LinkedList<Integer>[] graph,
                        int[] degree, int[] nums) {
        LinkedList<Integer> queue = new LinkedList<>();
        int n = graph.length;
        for(int i = 0; i < degree.length; i++){
            if(degree[i] == 1){
                queue.add(i);
            }
        }
        int[] d = degree.clone();
        int[] val = nums.clone();

        while (!queue.isEmpty()){
            int curr = queue.poll();
            d[curr] = 0;
            if(val[curr] > target) return false;
            for(int adj : graph[curr]){
                if(val[curr] != target) val[adj] += val[curr];
                d[adj]--;
                if(d[adj] == 0) {
                    return val[adj] == target;
                } else if(d[adj] == 1){
                    queue.offer(adj);
                }
            }
        }
        return true;
    }
}
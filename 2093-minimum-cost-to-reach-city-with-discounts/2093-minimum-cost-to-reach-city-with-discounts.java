class Solution {
    public int minimumCost(int n, int[][] highways, int discounts) {
        HashSet<int[]>[] graph = new HashSet[n];
        for(int i = 0; i < n; i++) graph[i] = new HashSet<>();
        for(int[] e : highways){
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        PriorityQueue<int[]> minQ = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        minQ.offer(new int[]{0,0,0});
        int[][] visited = new int[n][discounts + 1];
        for(int i = 0; i < n; i++) Arrays.fill(visited[i], Integer.MAX_VALUE);
        visited[0][0] = 0;

        while (!minQ.isEmpty()){
            int[] arr = minQ.poll();
            int cost = arr[0], city = arr[1], dis = arr[2];
            if(city == n - 1) return cost;
            for(int[] adj : graph[city]){
                int next = adj[0], weight = adj[1];
                if(cost + weight < visited[next][dis]){
                    minQ.offer(new int[]{cost + weight, next, dis});
                    visited[next][dis] = cost + weight;
                }
                if(dis < discounts &&
                        cost + weight / 2 < visited[next][dis + 1]){
                    minQ.offer(new int[]{cost + weight / 2, next, dis + 1});
                    visited[next][dis + 1] = cost + weight / 2;
                }
            }
        }
        return -1;
    }
}
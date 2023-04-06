class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        return solution1(maxTime, edges, passingFees);
    }
    public int solution2(int maxTime, int[][] edges, int[] passingFees) {
        // [src, time, cost]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        int n = passingFees.length;

        int [] minTime = new int[n];
        int [] minCost = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        Arrays.fill(minCost, Integer.MAX_VALUE);

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];
            int time = edges[i][2];
            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(dst, new ArrayList<>());
            graph.get(src).add(new int[]{dst, time});
            graph.get(dst).add(new int[]{src, time});
        }

        pq.offer(new int[]{0, 0 , passingFees[0]});

        // [src, time, cost]
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int src = curr[0];
            int time = curr[1];
            int cost = curr[2];
            for(int[] adj : graph.get(src)){
                int next_src = adj[0];
                int next_time = adj[1];
                int total_time = time + next_time;
                if(total_time <= maxTime){
                    if(minCost[next_src] > cost + passingFees[next_src]){
                        minCost[next_src] = cost + passingFees[next_src];
                        minTime[next_src] = total_time;
                        pq.offer(new int[]{next_src, minTime[next_src] , minCost[next_src]});
                    }else if(minTime[next_src] > total_time ){
                        minTime[next_src] = total_time;
                        pq.offer(new int[]{next_src, minTime[next_src] , cost + passingFees[next_src]});
                    }
                }
            }
        }
        int ans = minCost[n - 1];
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    
    public int solution1(int maxTime, int[][] edges, int[] passingFees) {
       // [src, time, cost]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        int n = passingFees.length;
        int [] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];
            int time = edges[i][2];
            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(dst, new ArrayList<>());
            graph.get(src).add(new int[]{dst, time});
            graph.get(dst).add(new int[]{src, time});
        }

        pq.offer(new int[]{0, 0 , passingFees[0]});

        // [src, time, cost]
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int src = curr[0];
            int time = curr[1];
            int cost = curr[2];
            if(time >= minTime[src]) continue;
            minTime[src] = time;
            if(src == n - 1 ){
                return cost;
            }
            for(int[] adj : graph.get(src)){
                int next_src = adj[0];
                int next_time = adj[1];
                int total_time = time + next_time;
                if(total_time > maxTime) continue;
                else if(total_time > minTime[next_src]) continue;
                
                pq.offer(new int[]{next_src, total_time , cost + passingFees[next_src]});
            }
        }
        return -1;
    }

}
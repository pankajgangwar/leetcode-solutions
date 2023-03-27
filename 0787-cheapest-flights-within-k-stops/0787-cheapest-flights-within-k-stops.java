class Solution {

    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights) {
            prices.putIfAbsent(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        int[][] visited = new int[n][k + 1];
        for (int i = 0; i < n; i++) Arrays.fill(visited[i], Integer.MAX_VALUE);
        visited[src][0] = 0;
        pq.add(new int[] { 0, src, 0 });
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int price = top[0], city = top[1], stops = top[2];
            if (city == dst) return price;

            Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
            for (int a : adj.keySet()) {
                int weight = adj.get(a);
                if(price + weight < visited[a][stops]){
                    pq.offer(new int[]{price + weight, a, stops});
                    visited[a][stops] = price + weight;
                }
                if(stops < k && price + weight < visited[a][stops + 1]){
                    pq.offer(new int[] { price + weight, a, stops + 1 });
                    visited[a][stops + 1] = price + weight;
                }
            }
        }
        return -1;
    }
    
    public int findCheapestPrice22(int n, int[][] flights, int src, int dst, int K) 
    {
        Map<Integer,List<int[]>> map=new HashMap<>();
        for(int[] f:flights)
        {
            map.putIfAbsent(f[0],new ArrayList<>());
            map.get(f[0]).add(new int[]{f[1],f[2]});
        }
        PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        q.offer(new int[]{0,src,K+1});
        while(!q.isEmpty())
        {
            int[] c=q.poll();
            int cost=c[0];
            int curr=c[1];
            int stop=c[2];
            if(curr==dst)
                return cost;
            if(stop>0)
            {
                if(!map.containsKey(curr))
                    continue;
                for(int[] next:map.get(curr))
                {
                    q.add(new int[]{cost+next[1],next[0],stop-1});
                }
            }
        }
        return -1;
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
    {
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        for(int i=0;i<=K;i++)
        {
            int[] temp= Arrays.copyOf(cost,n);
            for(int[] f: flights)
            {
                int curr=f[0],next=f[1],price=f[2];
                if(cost[curr]==Integer.MAX_VALUE)
                    continue;
                temp[next]=Math.min(temp[next],cost[curr]+price);
            }
            cost=temp;
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }

    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights) {
            if (!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[] { 0, src, k + 1 });
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) return price;
            if (stops > 0) {
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[] { price + adj.get(a), a, stops - 1 });
                }
            }
        }
        return -1;
    }
}

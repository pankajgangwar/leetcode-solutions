class Solution {
    
    public int minimumCost(int n, int[][] connections) {
        return minimumCostKruskals(n, connections);
       // return minimumCostPrims(n, connections);
    }
    public int minimumCostKruskals(int n, int[][] connections) {

        Arrays.sort(connections, (a,b) -> a[2] - b[2]);

        UnionFind unionfind = new UnionFind(n);
        int cost = 0;
        for(int i = 0; i < connections.length; i++) {
            int x = connections[i][0] - 1;
            int y = connections[i][1] - 1;

            int xroot = unionfind.find(x);
            int yroot = unionfind.find(y);

            if(xroot == yroot){
                continue;
            }
            unionfind.union(x, y);

            cost += connections[i][2];
        }
        if(unionfind.count() != 1){
            return -1;
        }
        return cost;
    }
    
    public int minimumCostPrims(int n, int[][] connections) {
        int i = 0, connected = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        HashMap<Integer,LinkedList<int[]>> map = new HashMap<>();
        for (int j = 0; j < n; j++) {
            map.put(j, new LinkedList<>());
        }
        for (int j = 0; j < connections.length; j++) {
            int src = connections[j][0] - 1;
            int dst = connections[j][1] - 1;
            int cost = connections[j][2];
            map.get(src).add(new int[]{cost, dst});
            map.get(dst).add(new int[]{cost, src});
        }
        int res = 0;
        while (++connected < n){
            visited[i] = true;
            LinkedList<int[]> adj = map.get(i);
            for (int j = 0; j < adj.size(); j++) {
                int cost = adj.get(j)[0];
                int next = adj.get(j)[1];
                if(!visited[next]){
                    pq.offer(new int[]{cost, next});
                }
            }
            while (!pq.isEmpty() && visited[pq.peek()[1]]){
                pq.poll();
            }
            if(pq.isEmpty()) return -1;
            int[] curr = pq.poll();
            res += curr[0];
            i = curr[1];
        }
        return res;
    }

    public class UnionFind {
        int root[];
        int rank[];
        int n;
        int count;
        public UnionFind(int n){
            this.n = n;
            count = n;
            root = new int[n];
            rank = new int[n];
            Arrays.fill(rank, -1);
            for(int i = 0; i < n; i++){
                root[i] = i;
            }
        }

        public int find(int x){
            while(x != root[x]){
                root[x] = root[root[x]];
                x = root[x];
            }
            return x;
        }

        public void union(int x, int y){
            int xroot = find(x);
            int yroot = find(y);
            if(xroot == yroot) return;
            if(rank[yroot] > rank[xroot]){
                root[xroot] = yroot;
            }else{
                root[yroot] = xroot;
                if(rank[xroot] == rank[yroot]){
                    rank[xroot]++;
                }
            }
            count--;
        }

        public int count() {
            return count;
        }
    }
}
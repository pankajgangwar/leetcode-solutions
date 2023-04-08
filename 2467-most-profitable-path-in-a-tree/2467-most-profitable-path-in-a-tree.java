class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length + 1;
        List<Integer>[] graph = new LinkedList[n];
        for(int i = 0; i < n; i++) graph[i] = new LinkedList<>();
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        List<Integer> path = new ArrayList<>();
        dfs(bob, graph, amount, new boolean[n], path);
        
        //System.out.println(path);
        
        int len = path.size() - 1;
        int i = len / 2;
        if(len % 2 == 0){
            int u = path.get(i);
            amount[u] = amount[u] / 2;
            while (i > 0){
                u = path.get(--i);
                amount[u] = 0;
            }
        }else{
            while (i >= 0){
                int u = path.get(i--);
                amount[u] = 0;
            }
        }
        System.out.println(Arrays.toString(amount));
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, amount[0]});

        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            int u = curr[0], c = curr[1];
            
            boolean isLeaf = true;
            for(int v : graph[u]){
                if(visited[v]) continue;
                visited[v] = true;
                isLeaf = false;
                queue.offer(new int[]{v, amount[v] + c});
            }
            if(isLeaf){
                //System.out.println(" is Leaf u " + u + " c " + c);
                max = Math.max(max, c);
            }
        }
        return max;
    }
    
    public boolean dfs(Integer u, List<Integer>[] g, int[] c, 
                       boolean[] visited, List<Integer> path){
        
        if(visited[u]) return false;
        path.add(u);
        if(u == 0) return true;
        visited[u] = true;
        for(int v : g[u]){
            if(v == u) continue;
            if(dfs(v, g, c, visited, path)) return true;
        }
        path.remove(u);
        return false;
    }
}
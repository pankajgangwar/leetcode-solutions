class Solution {
    
    public boolean isPrintable(int[][] targetGrid) {
        int maxN = 60;
        List<Integer>[] graph = new LinkedList[maxN + 1];
        for(int i = 0; i <= maxN; i++){
            graph[i] = new LinkedList<>();
        }
        int[] indegree = new int[maxN + 1];
        for(int i = 1; i <= maxN; i++){
            search(targetGrid, graph, i, indegree);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i <= maxN; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        HashSet<Integer> seen = new HashSet<>();
        while (!queue.isEmpty()){
            int u = queue.poll();
            if(!seen.add(u)) continue;
            for(int v : graph[u]){
                if(--indegree[v] == 0){
                    queue.offer(v);
                }
            }
        }
        return seen.size() == (maxN + 1);
    }

    public void search(int[][] grid, List<Integer>[] graph,
                       int source, int[] indegree){
        int row = grid.length, col = grid[0].length;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == source){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);

                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        if(minX == Integer.MAX_VALUE) return;
        for (int i = minX; i <= maxX ; i++) {
            for (int j = minY; j <= maxY ; j++) {
                if(grid[i][j] != source){
                    indegree[source]++;
                    graph[grid[i][j]].add(source);
                }
            }
        }
    }
}
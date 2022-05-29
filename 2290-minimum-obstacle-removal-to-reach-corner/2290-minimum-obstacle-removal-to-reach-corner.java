class Solution {
    public int minimumObstacles(int[][] grid) {
        PriorityQueue<int[]> bfs = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        bfs.offer(new int[]{0,0,0});
        boolean[][] vis = new boolean[m][n];
        int[][] min = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }
        
        vis[0][0] = true;
        while (!bfs.isEmpty()){
            int size = bfs.size();
            while (size-- > 0){
                int[] curr = bfs.poll();
                int x = curr[0], y = curr[1];
                int xx = curr[2];
                if(x == m -1 && y == n - 1) return xx;
                    
                for(int[] d : dirs){
                    int next_x = d[0] + x;
                    int next_y = d[1] + y;
                    if(isSafeMove(next_x, next_y, vis, m, n)){
                        int obst = grid[next_x][next_y];
                        vis[next_x][next_y] = true;
                        bfs.offer(new int[]{next_x, next_y, xx + obst});
                    }
                }
            }
        }
        return 0;
    }

    public boolean isSafeMove(int x, int y,boolean[][] visited, int rows, int cols) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y]) {
            return true;
        }
        return false;
    }
}
class Solution {
    public int[][] highestPeak(int[][] map) {
        int m = map.length;
        int n = map[0].length;
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(grid[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1){//water
                    grid[i][j] = 0;
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }
        bfs(map, grid, queue);
        return grid;
    }

    public void bfs(int[][] map, int[][] grid, Queue<int[]> queue){
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int m = map.length;
        int n = map[0].length;
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            int cr = curr[0], cc = curr[1], ch = curr[2];
            for(int[] d : dirs){
                int nr = cr + d[0];
                int nc = cc + d[1];
                int nh = ch + 1;
                if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if(map[nr][nc] == 0 && grid[nr][nc] > nh){
                    grid[nr][nc] = nh;
                    queue.offer(new int[]{nr, nc, nh});
                }
            }
        }
    }

}
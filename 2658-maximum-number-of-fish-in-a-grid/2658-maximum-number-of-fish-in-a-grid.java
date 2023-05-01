class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] != 0 && !visited[i][j]){
                    res = Math.max(res, getFishesBfs(grid, i, j, visited));
                }
            }
        }
        return res;
    }

    public int getFishesBfs(int[][] grid, int r, int c, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        visited[r][c] = true;
        int[][] dirs = new int[][] {{ -1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int fishes = 0;
        while (!q.isEmpty()){
            int[] curr = q.poll();
            fishes += grid[curr[0]][curr[1]];
            for(int[] d : dirs){
                int nr = d[0] + curr[0];
                int nc = d[1] + curr[1];
                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length
                        || visited[nr][nc] || grid[nr][nc] == 0){
                    continue;
                }
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
        System.out.println("Fishes " + fishes );
        return fishes;
    }

}
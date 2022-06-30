class Solution {
    public int swimInWater(int[][] grid) {
        int[] start = new int[]{0,0, grid[0][0]};
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a,b) -> Integer.compare(a[2], b[2])
        );
        queue.offer(start);
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] visited = new boolean[m][n];
        int dir[][] = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        int minTime = grid[0][0];
        visited[0][0] = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                int[] curr = queue.poll();
                minTime = Math.max(minTime, grid[curr[0]][curr[1]]);
                if(curr[0] == m-1 && curr[1] == n-1){
                    return minTime;
                }
                int next_x = 0, next_y = 0;
                for (int i = 0; i < dir.length; i++) {
                    next_x = curr[0] + dir[i][0];
                    next_y = curr[1] + dir[i][1];
                    if(isSafe(next_x, next_y, grid, visited)){
                        visited[next_x][next_y] = true;
                        queue.offer(new int[]{next_x, next_y, grid[next_x][next_y]});
                    }
                }
            }
        }
        return minTime;
    }
    
    private boolean isSafe(int next_x, int next_y, int[][] grid, boolean[][] visited) {
        if(next_x < 0 || next_y < 0 || next_x >= grid.length ||
                next_y >= grid[0].length || visited[next_x][next_y]){
            return false;
        }
        return true;
    }
}
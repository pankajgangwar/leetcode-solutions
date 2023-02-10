class Solution {
    public int maxDistance(int[][] grid) {
         Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean [][]visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int[][] dirs = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        int result = -1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                int[] curr = queue.poll();
                result = Math.max(result, grid[curr[0]][curr[1]] -1);
                for (int[] dir: dirs){
                    int next_x = curr[0] + dir[0];
                    int next_y = curr[1] + dir[1];
                    if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n
                            && !visited[next_x][next_y]){
                        visited[next_x][next_y] = true;
                        grid[next_x][next_y] = grid[curr[0]][curr[1]] + 1;
                        queue.offer(new int[]{next_x, next_y});
                    }
                }
            }
        }
        return result == 0 ? -1 : result;
    }
}
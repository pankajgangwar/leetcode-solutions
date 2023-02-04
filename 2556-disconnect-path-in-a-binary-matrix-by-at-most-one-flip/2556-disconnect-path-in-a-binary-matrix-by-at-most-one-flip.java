class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (!dfs(grid, 0, 0, m, n)) {
            return true;
        }
        if (dfs(grid, 0, 0, m, n)) {
            return false;
        }
        return true;
    }
    

    boolean dfs(int[][] grid, int curr_x, int curr_y, int m, int n) {
        if (curr_x == m - 1 && curr_y == n - 1){
            return true;
        }
        grid[curr_x][curr_y] = 0;
        int[][] dir = new int[][]{{1,0},{0,1}};
        for(int[] d : dir) {
            int next_x = d[0] + curr_x;
            int next_y = d[1] + curr_y;
            if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n
                    && grid[next_x][next_y] == 1 ){
                if (dfs(grid, next_x,next_y, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

}
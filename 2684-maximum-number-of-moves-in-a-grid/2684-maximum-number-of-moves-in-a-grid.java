class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], -1);
        }
        int max = 0;
        for(int j = 0; j < grid.length; j++){
            int curr = grid[j][0];
            visited[j][0] = curr;
            int a = dfs(grid, curr, j - 1, 0 + 1, visited);
            int b = dfs(grid, curr, j, 0 + 1, visited);
            int c = dfs(grid, curr, j + 1, 0 + 1, visited);
            int currMax = Math.max(Math.max(a, c), Math.max(a, b));
            max = Math.max(max, currMax);
        }
        return max;
    }

    private int dfs(int[][] grid, int prev, int row, int col, int[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if(row < 0 || row >= m || col < 0 || col >= n ) return 0;
        if(visited[row][col] != -1){
            return visited[row][col];
        }
        int curr = grid[row][col];
        if(curr <= prev) return 0;
        int a = dfs(grid, grid[row][col], row - 1 , col + 1, visited) + 1;
        int b = dfs(grid, grid[row][col], row , col + 1, visited) + 1;
        int c = dfs(grid, grid[row][col], row + 1 , col + 1, visited) + 1;
        int currMax = Math.max(Math.max(a, c), Math.max(a, b));
        visited[row][col] = currMax;
        return currMax;
    }
}
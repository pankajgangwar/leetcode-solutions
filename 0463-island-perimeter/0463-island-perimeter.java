class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        boolean [][]visited = new boolean[m][n];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return dfsIsland(grid, i, j, visited);
                }
            }
        }
        return 0;
    }
    
    public int dfsIsland(int[][] grid, int curr_x, int curr_y, boolean[][] visited){
        
        int m = grid.length;
        int n = grid[0].length;

        if(curr_x < 0 || curr_x >= m || curr_y < 0 || curr_y >= n ) {
            return 1;
        }

        if(grid[curr_x][curr_y] == 0){
            return 1;
        }

        if(visited[curr_x][curr_y]){
            return 0;
        }

        visited[curr_x][curr_y] = true;

        return dfsIsland(grid, curr_x + 1, curr_y, visited) +
                dfsIsland(grid, curr_x , curr_y + 1, visited) +
                dfsIsland(grid, curr_x - 1, curr_y, visited) + 
                dfsIsland(grid, curr_x , curr_y - 1, visited);
    }
}
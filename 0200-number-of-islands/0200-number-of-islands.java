class Solution {
     public int numIslands(char[][] grid) {
       return numIslandsDFS(grid);
    }
    
     public int numIslandsDFS(char[][] grid){
        if(grid == null || grid.length == 0)return 0;
        int m = grid.length;
        int n = grid[0].length;

        boolean [][]visited = new boolean[m][n];
        int num_of_island = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]){
                    DFSUtil(grid, i, j, m, n, visited);
                    num_of_island++;
                }
            }
        }
        return num_of_island;
    }

    private void DFSUtil(char[][] grid,int i, int j, 
                         int rows, int cols,boolean[][] visited){
       visited[i][j] = true;
        int [][]dir = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        for (int k = 0; k < dir.length ; k++) {
            int next_x = i + dir[k][0];
            int next_y = j + dir[k][1];

            if(next_x >= 0 && next_x < rows && next_y >= 0 && next_y < cols
                    && grid[next_x][next_y] == '1' && !visited[next_x][next_y]){
                DFSUtil(grid, next_x, next_y, rows, cols, visited);
            }
        }
    }
    
    public int numIslandsBFS(char[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int isLands = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    isLands++;
                    BFSIsland(grid,i ,j, m , n);
                }
            }
        }
        return isLands;
    }

    private void BFSIsland(char[][] grid, int i, int j, int rows, int cols) {
        int dir[][] = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        
        grid[i][j] = '0';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});

        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                int[] cur = queue.poll();
                for (int k = 0; k < dir.length; k++) {
                    int next_x = cur[0] + dir[k][0];
                    int next_y = cur[1] + dir[k][1];

                    if(next_x >= 0 && next_x < rows && next_y >= 0
                            && next_y < cols && grid[next_x][next_y] == '1'){

                        grid[next_x][next_y] = '0';
                        queue.offer(new int[]{next_x, next_y});
                        
                    }
                }
            }
        }
    }
}
class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, findArea(i, j, grid));
                }
            }
        }
        return maxArea;
    }

    public int findArea(int i, int j, int[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        int area = 0;
        queue.offer(new int[]{i, j});
        grid[i][j] = 0;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()){
            int size = queue.size();
            area += size;
            while (size-- > 0){
                int[] curr = queue.poll();
                int curr_x = curr[0];
                int curr_y = curr[1];
                for (int k = 0; k < dirs.length; k++) {
                    int next_x = dirs[k][0] + curr_x;
                    int next_y = dirs[k][1] + curr_y;
                    if(isSafe(next_x, next_y, grid)){
                        queue.offer(new int[]{next_x, next_y});
                        grid[next_x][next_y] = 0;
                    }
                }
            }
        }
        return area;
    }

    private boolean isSafe(int next_x, int next_y, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(next_x < 0 || next_y < 0 || next_x >= m || next_y >= n || grid[next_x][next_y] == 0){
            return false;
        }
        return true;
    }

}
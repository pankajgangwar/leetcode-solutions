class Solution {
     public int minArea(char[][] image, int x, int y) {
        Queue<int[]> bfs = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        int area = m * n;
        boolean[][] visited = new boolean[m][n];

        visited[x][y] = true;
        bfs.offer(new int[]{x,y});
        int left = m, top = n, right = 0, bottom = 0;
        while (!bfs.isEmpty()){
            int size = bfs.size();
            while (size-- > 0){
                int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
                int[] curr = bfs.poll();
                int curr_x = curr[0];
                int curr_y = curr[1];

                left = Math.min(left, curr_x);
                top = Math.min(top, curr_y);
                right = Math.max(right, curr_x);
                bottom = Math.max(bottom, curr_y);

                for(int[] dir : dirs){
                    int next_x = dir[0] + curr[0];
                    int next_y = dir[1] + curr[1];
                    if(isSafe(next_x, next_y, image, visited)){
                        bfs.offer(new int[]{next_x, next_y});
                        visited[next_x][next_y] = true;
                    }
                }
            }
        }
        return (right - left + 1) * (bottom - top + 1);
    }

    boolean isSafe(int i, int j, char[][] grid, boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0' || visited[i][j]){
            return false;
        }
        return true;
    }
}
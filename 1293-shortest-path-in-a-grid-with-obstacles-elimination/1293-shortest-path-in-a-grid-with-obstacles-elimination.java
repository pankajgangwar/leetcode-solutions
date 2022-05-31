class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] == 1 || grid[m -1][n-1] == 1){
            return -1;
        }
        int[][] paths = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        Queue<int[]> mQueue = new LinkedList<>();
        mQueue.offer(new int[]{0,0,0});
        boolean visited[][][] = new boolean[m][n][k+1];
        int min_distance = 0;
        visited[0][0][0] = true;

        while (!mQueue.isEmpty()){
            int size = mQueue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = mQueue.poll();
                if(curr[0] == m - 1 && curr[1] == n -1){
                    return min_distance ;
                }
                for (int j = 0; j < paths.length; j++) {
                    int next_x = paths[j][0] + curr[0];
                    int next_y = paths[j][1] + curr[1];
                    if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n){

                        if(grid[next_x][next_y] == 0 && !visited[next_x][next_y][curr[2]]){

                            mQueue.offer(new int[]{next_x,next_y, curr[2]});
                            visited[next_x][next_y][curr[2]] = true;

                        }else if(grid[next_x][next_y] == 1 && curr[2] < k && !visited[next_x][next_y][curr[2]+1]){

                            mQueue.offer(new int[]{next_x,next_y, curr[2]+1});
                            visited[next_x][next_y][curr[2]+1] = true;
                        }
                    }
                }
            }
            min_distance++;
        }
        return -1;
    }
}
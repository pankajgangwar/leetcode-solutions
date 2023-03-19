class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if((grid[0][0] != 0)) return false;
        return helper(0,0, grid);
    }

    public boolean helper(int curr_x, int curr_y, int[][] grid) {
        int N = grid.length;
        int curr = grid[curr_x][curr_y];
        if(curr + 1 == (N*N)) return true;

        int[] x_move = new int[] { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] y_move = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };

        for(int i = 0; i < x_move.length; i++){
            int next_x = curr_x + x_move[i];
            int next_y = curr_y + y_move[i];
            if(isValid(next_x, next_y, grid, curr) &&
                    helper(next_x, next_y, grid)){
                    return true;
            }
        }
        return false;
    }

    public boolean isValid(int next_i, int next_j, int[][] grid, int curr) {
        int N = grid.length;
        if(next_i >= 0 && next_i < N && next_j >= 0 && next_j < N && grid[next_i][next_j] == curr + 1) {
            return true;
        }
        return false;
    }
}
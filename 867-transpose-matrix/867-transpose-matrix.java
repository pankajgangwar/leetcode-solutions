class Solution {
    public int[][] transpose(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] res = new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                res[i][j] = grid[j][i];
            }
        }
        return res;
    }
}
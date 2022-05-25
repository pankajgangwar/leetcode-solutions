class Solution {
    public int matrixScore(int[][] grid) {
        int row = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < row; i++) {
            if(grid[i][0] == 0){
                flipRow(i, grid);
            }
        }
        int[] colCount = new int[cols];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    colCount[j]++;
                }
            }
        }
        for (int i = 0; i < colCount.length; i++) {
            if(row - colCount[i] > colCount[i]){
                flipCol(i, grid);
            }
        }
        int res = 0;
        res = arrayToBinary(grid);
        return res;
    }

    private int arrayToBinary(int[][] matrix) {
        int score = 0;
        for (int i = 0; i < matrix.length; i++) {
            int binary = 0;
            int n = matrix[i].length;
            for (int j = 0; j < matrix[i].length; j++) {
                binary += matrix[i][j] * (Math.pow(2, n - 1 - j));
            }
            score += binary;
        }
        return score;
    }

    private void flipCol(int col, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = matrix[i][col] ^ 1;
        }
    }

    public void flipRow(int row, int[][] matrix){
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = matrix[row][i] ^ 1;
        }
    }
}
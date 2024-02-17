class Solution {
    
     class Cell {
        int row, col;
        public Cell(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        Cell[][] dp1 = new Cell[n][n];
        Cell[][] dp2 = new Cell[n][n];
        int[][] grid = new int[n][n];
        for(int[] c : grid){
            Arrays.fill(c, 1);
        }
        for(int[] c : mines){
            grid[c[0]][c[1]] = 0;
        }
        for(int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                dp1[i][j] = new Cell(0, 0);
                dp2[i][j] = new Cell(0, 0);
            }
        }
        for(int i = n - 1; i >= 0 ; i--){
            for(int j = n - 1; j >= 0 ; j--){
                if(grid[i][j] == 1){
                    dp1[i][j].row = 1 + (j < n - 1 ? dp1[i][j + 1].row : 0);
                    dp1[i][j].col = 1 + (i < n - 1 ? dp1[i + 1][j].col : 0);
                }else{
                    dp1[i][j].row =  dp1[i][j].col = 0;
                }
                
                int r1 = dp1[i][j].row;
                int c1 = dp1[i][j].col;
            }
        }
        
        int min = 0;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ; j++){
                if(grid[i][j] == 1){
                    dp2[i][j].row = 1 + (j > 0 ? dp2[i][j - 1].row : 0);
                    dp2[i][j].col = 1 + (i > 0 ? dp2[i - 1][j].col : 0);
                    
                    int a = Math.min(dp1[i][j].col, dp2[i][j].col);
                    int b = Math.min(dp1[i][j].row, dp2[i][j].row);
                    min = Math.max(min,  Math.min(a, b));
                }else{
                    dp2[i][j].row =  dp2[i][j].col = 0;
                }
                int r1 = dp2[i][j].row;
                int c1 = dp2[i][j].col;
            }
        }
        return min;
    }
}
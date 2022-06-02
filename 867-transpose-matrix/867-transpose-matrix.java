class Solution {
    public int[][] transpose(int[][] grid) {
        int i = 0, j = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] res = new int[cols][rows];
        while (i < rows && j < cols){
            int tempr = 0;
            int tempc = 0;
            while (tempr <= i && tempc <= j){
                int first = grid[tempr][j];
                int second = grid[i][tempc];
                res[tempr][j] = second;
                res[i][tempc] = first;
                tempr++;
                tempc++;
            }
            i++;
            j++;
        }
        if(rows == cols){
            return res;
        }else{
            res = new int[cols][rows];
            int tempR = 0, tempC = 0;
            for (int k = 0; k < rows; k++) {
                for (int l = 0; l < cols; l++) {
                    if(tempR == cols){
                        tempR = 0;
                        tempC++;
                    }
                    res[tempR++][tempC] = grid[k][l];
                }
            }
        }

        return res;
    }
}
class Solution {
    public int removeOnes(int[][] grid) {
        int res = Integer.MAX_VALUE;
        int r = grid.length;
        int c = grid[0].length;
        int[] cols = new int[r];
        int[] rows = new int[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == 0){
                    continue;
                }
                for (int k = 0; k < r; k++) {
                    cols[k] = grid[k][j];
                    grid[k][j] = 0;
                }
                for (int k = 0; k < c; k++) {
                    rows[k] = grid[i][k];
                    grid[i][k] = 0;
                }
                res = Math.min(res , 1 + (removeOnes(grid)));
                //Backtrack
               for (int k = 0; k < c; k++) {
	            grid[i][k] = rows[k];
	       }
	       for (int k = 0; k < r; k++) {
	            grid[k][j] = cols[k];
	       }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
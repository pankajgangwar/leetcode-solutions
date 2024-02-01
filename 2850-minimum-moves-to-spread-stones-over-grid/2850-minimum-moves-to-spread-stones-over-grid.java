class Solution {
    public int minimumMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cells = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    cells++;
                }
            }
        }
        if(cells == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0){
                    for(int ni = 0; ni < m; ni++) {
                        for (int nj = 0; nj < n; nj++) {
                            int d = Math.abs(ni - i) + Math.abs(nj - j);
                            if(grid[ni][nj] > 1){
                                grid[ni][nj]--;
                                grid[i][j]++;
                                ans = Math.min(ans, d + minimumMoves(grid));
                                grid[ni][nj]++;
                                grid[i][j]--;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
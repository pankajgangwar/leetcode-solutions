class Solution {
    public int countPyramids(int[][] grid) {
        int[][] r = reverse(grid);
        return count(grid) + count(r);
    }

    public int count(int[][] g){
        int ans = 0;
        int m = g.length, n = g[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n - 1; j++) {
                if(g[i][j] > 0){
                    g[i][j] = Math.min(g[i-1][j], Math.min(g[i-1][j-1], g[i-1][j+1])) + 1;
                    ans += g[i][j] - 1;
                }
            }
        }
        return ans;
    }
    
    public int[][] reverse(int[][] g){
        int m = g.length, n = g[0].length;
        int [][] reversed = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                reversed[i][j] = g[m - i - 1][j];
            }
        }
        return reversed;
    }
}
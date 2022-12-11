class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int max = -1;
        for (int i = 0; i < grid.length; i++) {
            int m = Arrays.stream(grid[i]).max().getAsInt();
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == m){
                    grid[i][j] = 0;
                    break;
                }
            }
            max = Math.max(max, m);
        }
        if(max == 0) return max;
        return max + deleteGreatestValue(grid);
    }
}
class Solution {
    public int removeOnes(int[][] grid) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0){
                    continue;
                }
                List<Integer> x = new ArrayList<>();
                for (int k = 0; k < grid.length; k++) {
                    if(grid[k][j] == 1){
                        x.add(k);
                        grid[k][j] = 0;
                    }
                    
                }
                List<Integer> y = new ArrayList<>();
                for (int k = 0; k < grid[0].length; k++) {
                    if(grid[i][k] == 1){
                        y.add(k);
                        grid[i][k] = 0;
                    }
                }
                res = Math.min(res , 1 + (removeOnes(grid)));
                //Backtrack
                for (int k : x) {
                    grid[k][j] = 1;
                }
                for (int k : y) {
                    grid[i][k] = 1;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
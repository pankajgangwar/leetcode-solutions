class Solution {
    public boolean removeOnes(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            int[] row = grid[i];
            if(!Arrays.equals(grid[0], row) && !Arrays.equals(grid[0], compliment(row))){
                return false;
            }
        }
        return true;
    }
    public int[] compliment(int[] row){
        int[] copy = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            copy[i] = row[i] ^ 1;
        }
        return copy;
    }
}
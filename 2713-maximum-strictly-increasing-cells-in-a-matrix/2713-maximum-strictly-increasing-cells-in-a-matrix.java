class Solution {
    public int maxIncreasingCells(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dp = new int[m][n];
        int[] row = new int[m];
        int[] col = new int[n];
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.putIfAbsent(mat[i][j], new ArrayList<>());
                map.get(mat[i][j]).add(new int[]{i,j});
            }
        }
        for (int val : map.keySet()) {
            for(int[] cell : map.get(val)){
                int i = cell[0];
                int j = cell[1];
                dp[i][j] = Math.max(col[j], row[i]) + 1;
            }
            for(int[] cell : map.get(val)){
                int i = cell[0];
                int j = cell[1];
                row[i] = Math.max(dp[i][j], row[i]);
                col[j] = Math.max(dp[i][j], col[j]);
            }
        }
        int max = Arrays.stream(row).max().getAsInt();
        max = Math.max(max, Arrays.stream(col).max().getAsInt());
        return max;
        
    }
}
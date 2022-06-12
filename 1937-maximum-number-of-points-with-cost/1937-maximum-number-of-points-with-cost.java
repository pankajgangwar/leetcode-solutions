class Solution {
    public long maxPoints(int[][] points) {
        //return solve(points, 0, -1);
        int r = points.length;
        int c = points[0].length;
        /*long[][] memo = new long[r + 10][c + 10];
        for (int i = 0; i <= r; i++) {
            Arrays.fill(memo[i], -1);
        }
        solveMemo(points, 0, 0, memo);
        System.out.println(Arrays.toString(memo[0]));
        return Arrays.stream(memo[0]).max().getAsLong();*/
        return solveDPOptimal(points);
    }
    
    public long solveDPOptimal(int[][] points){
        int r = points.length;
        int c = points[0].length;
        long[][] dp = new long[r][c];
        for (int i = 0; i < c; i++) {
            dp[0][i] = points[0][i];
        }
        for (int i = 1; i < r ; i++) {
            long[] leftDp = new long[c];
            long[] rightDp = new long[c];
            leftDp[0] = dp[i - 1][0];
            for (int j = 1; j < c; j++) {
                leftDp[j] = Math.max(leftDp[j - 1] - 1, dp[i - 1][j] );
            }
            rightDp[c - 1] = dp[i - 1][c - 1];
            for (int j = c - 2 ; j >= 0; --j) {
                rightDp[j] = Math.max(rightDp[j + 1] - 1, dp[i - 1][j]);
            }

            for (int j = 0; j < c; j++) {
                dp[i][j] = Math.max(leftDp[j], rightDp[j]) + points[i][j];
            }
        }
        return Arrays.stream(dp[r - 1]).max().getAsLong();
    }
    
    public long solveDP(int[][] points){
        int r = points.length;
        int c = points[0].length;
        long[][] dp = new long[r + 1][c + 1];
        for (int i = 1; i <= r ; i++) {
            for (int j = 1; j <= c; j++) {
                if(i == 1){
                    dp[i][j] = points[i -1][j - 1];
                }else{
                    for (int k = 1; k <= c; k++) {
                        dp[i][j] = Math.max(dp[i][j],
                                points[i - 1][j - 1] - Math.abs(k - j) + dp[i - 1][k]);
                    }
                }
            }
        }
        return Arrays.stream(dp[r]).max().getAsLong();
    }

    public long solveMemo(int[][] points, int currRow, int currCol, long[][] memo){
        int r = points.length;
        int c = points[0].length;
        if(currRow == r){
            return 0;
        }
        if(memo[currRow][currCol] != -1) {
            return memo[currRow][currCol];
        }
        long maxPoints = 0;
        for (int col = 0; col < c; col++) {
            long currPoints = points[currRow][col] - (currRow == 0 ? 0 : Math.abs(currCol - col))
                            + solveMemo(points, currRow + 1, col, memo);
            maxPoints = Math.max(maxPoints,currPoints);
        }
        return memo[currRow][currCol] = maxPoints;
    }

    public long solve(int[][] points, int currRow, int prevCol){
        int r = points.length;
        int c = points[0].length;
        if(currRow == r){
            return 0;
        }
        long maxPoints = 0;
        for (int currCol = 0; currCol < c; currCol++) {
            maxPoints = Math.max(maxPoints,
                    points[currRow][currCol] - (prevCol == -1 ? 0 : Math.abs(prevCol - currCol))
                            + solve(points, currRow + 1, currCol));
        }
        return maxPoints;
    }
}
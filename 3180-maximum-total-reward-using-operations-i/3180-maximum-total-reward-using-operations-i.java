class Solution {
    
     public int maxTotalReward(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        boolean[] dp = new boolean[50000];
        dp[0] = true;
        int max = 0;
        for(int i = 0 ; i < n; i++){
            if(i == 0 || A[i-1] != A[i]){
                int limit = Math.min(A[i], A[n-1] - A[i]);
                for (int j = 0; j < limit; j++) {
                    if(dp[j]){
                        dp[j + A[i]] = true;
                        max = Math.max(max, j + A[i]);
                    }
                }
            }
        }
        return max + A[n-1];
    }
    
    public int maxTotalRewardRecursive(int[] A) {
        Arrays.sort(A);
        int[][] memo = new int[A.length][(int)1e4];
        return helper(0, memo, A, 0);
    }

    public int helper(int idx, int[][] memo, int[] A, int max){
        if(idx == A.length){
            return max;
        }
        if(memo[idx][max] != 0 ) return memo[idx][max];
        int curr = 0;
        if(max < A[idx]){
            int a = helper(idx + 1, memo, A, max + A[idx]);
            curr = Math.max(curr, a);
        }
        int b = helper(idx + 1, memo, A, max);
        curr = Math.max(curr, b);
        return memo[idx][max] = curr;
    }
    
}
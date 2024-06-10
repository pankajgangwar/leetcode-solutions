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
    
    public int recursiveSol(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for(int i = 0; i < n; i++) dp[i] = new HashMap<>();
        return helper(0, dp, A, 0);
    }

    public int helper(int idx, 
                      HashMap<Integer, Integer>[] memo, 
                      int[] A, int max){
        if(idx == A.length){
            return max;
        }
        if(memo[idx].containsKey(max)) return memo[idx].get(max);
        int curr = 0;
        if(max < A[idx]){
            int a = helper(idx + 1, memo, A, max + A[idx]);
            curr = Math.max(curr, a);
        }
        int b = helper(idx + 1, memo, A, max);
        curr = Math.max(curr, b);
        memo[idx].put(max,curr);
        return curr;
    }
}
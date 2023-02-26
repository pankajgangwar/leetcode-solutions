class Solution {
      public int minNumberOfSemesters(int n,
                                    int[][] relations,
                                    int k) {
        int[] dependency = new int[n];
        for(int[] r : relations){
            int u = r[0] - 1;
            int v = r[1] - 1;
            dependency[v] |= 1 << u;
        }
        int[] prerequisites = new int[1 << n];
        for (int i = 0; i < (1 << n); ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) > 0) {
                    prerequisites[i] |= dependency[j];
                }
            }
        }
        int[] dp = new int[1 << n];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = n + 1;
        }
        for (int i = 1; i < (1 << n); ++i) {
            // iterate all submask of mask i, and this mask is the mask of last semester
            // see: https://cp-algorithms.com/algebra/all-submasks.html
            for (int j = i; j > 0; j = (j - 1) & i) {
                if (count_setbit(j) > k) {
                    continue;
                }

                int already_taken = i ^ ((1 << n) - 1);
                if ((already_taken & prerequisites[j]) == prerequisites[j]) {
                    dp[i] = Math.min(dp[i], dp[i ^ j] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }

    private int count_setbit(int mask) {
        if (mask == 0) {
            return 0;
        }
        return 1 + count_setbit(mask & (mask - 1));
    }
}
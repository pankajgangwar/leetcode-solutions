class Solution {
    
    int k;
    int[][][] memo;
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if(n == 1) return 0;
        this.k = k;
        memo = new int[n + 1][n + 1][k + 1];
        int[] prefSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefSum[i] = prefSum[i-1] + stones[i-1];
        }
        int res = mergeStones(1, n, 1, prefSum);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int mergeStones(int i, int j, int piles, int[] prefSum){
        if(memo[i][j][piles] != 0){
            return memo[i][j][piles];
        }
        if(j - i + 1 < piles) return Integer.MAX_VALUE;
        if(i == j) return (piles == 1) ? 0 : Integer.MAX_VALUE;
        if(piles == 1){
            int subMinCost = mergeStones(i, j, k, prefSum);
            if(subMinCost != Integer.MAX_VALUE){
                memo[i][j][piles] = prefSum[j] - prefSum[i - 1] + subMinCost;
            }else{
                memo[i][j][piles] = subMinCost;
            }
            return memo[i][j][piles];
        }
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int leftCost = mergeStones(i, k, piles - 1, prefSum);
            if(leftCost == Integer.MAX_VALUE) continue;
            int rightCost = mergeStones(k + 1, j, 1, prefSum);
            if(rightCost == Integer.MAX_VALUE) continue;
            minCost = Math.min(leftCost + rightCost, minCost);
        }
        memo[i][j][piles] = minCost;
        return minCost;
    }
}

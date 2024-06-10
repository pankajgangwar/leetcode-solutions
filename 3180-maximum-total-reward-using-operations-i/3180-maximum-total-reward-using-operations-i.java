class Solution {
    
    public int maxTotalReward(int[] A) {
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
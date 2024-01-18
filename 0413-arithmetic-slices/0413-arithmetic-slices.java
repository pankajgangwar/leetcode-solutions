class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        if(n <= 2) return 0;
        for (int i = 2; i < arr.length; i++) {
            int first = arr[i - 1] - arr[i - 2];
            int second = arr[i] - arr[i - 1];
            if(first == second){
                dp[i] = 1 + dp[i - 1];
            }
        }
        return Arrays.stream(dp).sum();
    }
}
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = Arrays.stream(rolls).sum();
        int m = rolls.length;
        int prod = mean * (m + n);
        int missingSum = prod - sum;
        if (missingSum < n || missingSum > 6*n) return new int[0];
        int[] ans = new int[n];
        int rem = missingSum % n;
        int part = missingSum/  n;
        Arrays.fill(ans, part);
        for(int i = 0; i < rem; i++ ){
            ++ans[i];
        }
        return ans;
    }
}
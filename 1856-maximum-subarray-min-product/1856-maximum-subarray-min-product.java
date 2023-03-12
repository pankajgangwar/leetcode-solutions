class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        Stack<Integer> lStack = new Stack<>();
        Stack<Integer> rStack = new Stack<>();

        int[] l = new int[n];
        for (int i = 0; i < n; i++) {
            while (!lStack.isEmpty() && nums[lStack.peek()] >= nums[i]){
                lStack.pop();
            }
            l[i] = lStack.isEmpty() ? 0 : lStack.peek() + 1;
            lStack.push(i);
        }

        int[] r = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!rStack.isEmpty() && nums[rStack.peek()] >= nums[i]){
                rStack.pop();
            }
            r[i] = rStack.isEmpty() ? n-1 : rStack.peek() - 1;
            rStack.push(i);
        }
        long[] prefixsum = new long[n];
        prefixsum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixsum[i] = prefixsum[i - 1] + nums[i];
        }
        long res = 0;
        long mod = (long)1e9+7;
        for (int i = 0; i < n; i++) {
            long sum = nums[i] * (prefixsum[r[i]] - (l[i] == 0 ? 0 : prefixsum[l[i] - 1]));
            res = Math.max(res, sum);
        }
        return (int)(res % mod);
    }
}
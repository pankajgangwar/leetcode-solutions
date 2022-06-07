class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        if(n == 2) return Math.abs(nums[0] - nums[1]);
        int[][] arr1 = generate(Arrays.copyOfRange(nums, 0, n / 2));
        int[][] arr2 = generate(Arrays.copyOfRange(nums, n/2, n));
        int ans = Integer.MAX_VALUE;
        for (int d = 0; d <= n/2 ; d++) {
            int[] a = arr1[d];
            int[] b = arr2[d];
            int l = a.length;
            int i = 0, j = 0;
            while (i < l && j < l){
                int diff = a[i] - b[j];
                ans = Math.min(ans, Math.abs(diff));
                if(diff <= 0){
                    i++;
                }
                if(diff >= 0){
                    j++;
                }
            }
        }
        return ans;
    }

    private int[][] generate(int[] arr) {
        int n = arr.length;
        int[][] ans = new int[n+1][];
        int[] pos = new int[n+1];
        int total = Arrays.stream(arr).sum();
        for (int i = 0, binomial = 1; i <= n ; i++) {
            ans[i] = new int[binomial];
            binomial = binomial * (n-i) / (i+1);
        }
        int maxValue = 1 << n;
        for(int key = 0; key < maxValue; key++){
            int sum1 = 0;
            for (int i = 0; i < n; i++) {
                if((key >> i & 1) == 1) sum1 += arr[i];
            }
            int sum2 = total - sum1;
            int bits = Integer.bitCount(key);
            ans[bits][pos[bits]++] = sum1 - sum2;
        }
        for(int[] a : ans) Arrays.sort(a);
        return ans;
    }
}
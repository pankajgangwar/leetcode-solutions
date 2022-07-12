class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            diff[i] = d;
        }
        int M = Arrays.stream(diff).max().getAsInt();
        int[] bucket = new int[M+1];
        for (int i = 0; i < n; i++) {
            bucket[diff[i]]++;
        }
        int k = k1 + k2;
        for (int i = M; i > 0 ; --i) {
            if(bucket[i] > 0){
                int minus = Math.min(k, bucket[i]);
                bucket[i] -= minus;
                bucket[i-1] += minus;
                k -= minus;
            }
        }
        long res = 0;
        for (int i = M; i > 0; --i) {
            res += (long) bucket[i] * i * i;
        }
        return res;
    }
}
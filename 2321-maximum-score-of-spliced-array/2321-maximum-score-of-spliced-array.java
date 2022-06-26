class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int a = kadane(nums1, nums2);
        int b = kadane(nums2, nums1);
        return Math.max(a, b);
    }

    public int kadane(int[] A, int[] B){
        int curr = 0, max = 0;

        for (int i = 0; i < A.length; i++) {
            curr = Math.max(0, curr + A[i] - B[i]);
            max = Math.max(max, curr);
        }
        return Arrays.stream(B).sum() + max;
    }
}
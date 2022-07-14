class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = (long)-10e10, high = (long)10e10;
        while (low < high){
            long mid = low + (high - low) / 2;
            if((check(nums1, nums2 , mid)) >= k){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    private long check(int[] nums1, int[] nums2, long target) {
        long res = 0;
        for(int n1 : nums1){
            if(n1 < 0){
                res += find1(nums2, (long)n1, target);
            }else if(n1 > 0){
                res += find2(nums2, (long)n1, target);
            }else{
                res += target >= 0 ? nums2.length : 0;
            }
        }
        return res;
    }

    private int find1(int[] nums2, long n1, long target) {
        int low = 0, high = nums2.length;
        while (low < high){
            int m = low + (high - low) / 2;
            if(n1 * nums2[m] <= target){
                high = m;
            }else{
                low = m + 1;
            }
        }
        return nums2.length - low;
    }

    private int find2(int[] nums2, long n1, long target) {
        int low = 0, high = nums2.length;
        while (low < high){
            int m = low + (high - low) / 2;
            if(n1 * nums2[m] > target){
                high = m;
            }else{
                low = m + 1;
            }
        }
        return low;
    }

}
class Solution {
    
    public long kthSmallestProduct(int[] A, int[] B, long k) {
        long low = (long)-10e10, high = (long)10e10;
        List<Integer> A1 = new ArrayList<>();
        List<Integer> A2 = new ArrayList<>();

        List<Integer> B1 = new ArrayList<>();
        List<Integer> B2 = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            if(A[i] < 0){
                A1.add(A[i] * -1);
            }else{
                A2.add(A[i]);
            }
        }

        for (int i = 0; i < B.length; i++) {
            if(B[i] < 0){
                B1.add(B[i] * -1);
            }else{
                B2.add(B[i]);
            }
        }
        Collections.sort(A1);
        Collections.sort(B1);

        int negatives = A1.size() * B2.size() + A2.size() * B1.size();
        int s = 1;
        if(k > negatives){
            k -= negatives;
            s = 1;
        }else{
            k = negatives - k + 1;
            List<Integer> temp = B1;
            B1 = B2;
            B2 = temp;
            s = -1;
        }

        while (low < high){
            long mid = low + (high - low) / 2;
            if((check(A1, B1 , mid)) + check(A2, B2, mid) >= k){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low * s;
    }

    private long check(List<Integer> nums1, List<Integer> nums2, long target) {
        long res = 0;
        int j = nums2.size() - 1;
        for(int n1 : nums1){
            while (j >= 0 && (long)n1 * (long)nums2.get(j) > target){
                j -= 1;
            }
            res += (j + 1);
        }
        return res;
    }
    
    public long kthSmallestProductSlow(int[] nums1, int[] nums2, long k) {
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
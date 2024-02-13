class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] ans = new int[2];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int a = 0, b = 0;
        for (int i = 0; i < nums1.length; i++) {
            int idx = Arrays.binarySearch(nums2, nums1[i]);
            if(idx >= 0) a++;
        }
        for (int i = 0; i < nums2.length; i++) {
            int idx = Arrays.binarySearch(nums1, nums2[i]);
            if(idx >= 0) b++;
        }
        ans[0] = a;
        ans[1] = b;
        return ans;
    }
}
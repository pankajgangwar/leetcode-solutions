class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] res = new int[n + m][2];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (nums1[i][0] < nums2[j][0]) {
                res[k++] = nums1[i++];
            } else if (nums1[i][0] > nums2[j][0]) {
                res[k++] = nums2[j++];
            }else{
                res[k++] = new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]};
                i++;j++;
            }
        }
        while (i < n) {
            res[k++] = nums1[i++];
        }
        while (j < m) {
            res[k++] = nums2[j++];
        }
        return Arrays.copyOfRange(res, 0, k);
    }
}
class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] index_in_b = new int[n];
        for(int i = 0; i < n; i++){
            int a = nums2[i];
            index_in_b[a] = i;
        }
        List<Integer> index_in_b_sorted = new ArrayList<>();
        long[] prea = new long[n];
        for(int i = 0; i < n; i++){
            int idxInB = index_in_b[nums1[i]];
            int idx_in_list = 0 - Collections.binarySearch(index_in_b_sorted, idxInB) - 1;
            prea[i] = idx_in_list;
            index_in_b_sorted.add(idx_in_list, idxInB);
        }
        index_in_b_sorted.clear();
        long[] suffA = new long[n];
        for(int i = n - 1; i >= 0; --i){
            int idxInB = index_in_b[nums1[i]];
            int idx_in_list = 0 - Collections.binarySearch(index_in_b_sorted, idxInB) - 1;
            suffA[i] = index_in_b_sorted.size() - idx_in_list;
            index_in_b_sorted.add(idx_in_list, idxInB);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += prea[i] * (suffA[i]);
        }
        return ans;
    }
}
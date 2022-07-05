class Solution {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0, sum1 = 0, sum2 = 0;
        for (int i = 0; i < n1; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
            int diff = sum1 - sum2;
            if(map.containsKey(diff)){
                max = Math.max(max, i - map.get(diff));
            }else{
                map.put(diff, i);
            }
        }
        return max;
    }
}
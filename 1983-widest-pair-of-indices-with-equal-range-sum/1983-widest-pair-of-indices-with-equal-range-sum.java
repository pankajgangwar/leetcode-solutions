class Solution {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
       int n1 = nums1.length;
        int n2 = nums2.length;
        int[] p1 = new int[n1 + 1];
        int[] p2 = new int[n2 + 1];
        for (int i = 1; i <= n1; i++) {
            p1[i] = p1[i-1] + nums1[i-1];
        }
        for (int i = 1; i <= n2; i++) {
            p2[i] = p2[i-1] + nums2[i-1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < p1.length; i++) {
            int diff = p1[i] - p2[i];
            if(map.containsKey(diff)){
                max = Math.max(max, i - map.get(diff));
            }else{
                map.put(diff, i);
            }
        }
        return max; 
    }
}
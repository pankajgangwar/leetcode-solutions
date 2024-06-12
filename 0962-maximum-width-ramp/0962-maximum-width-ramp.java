class Solution {
    public int maxWidthRamp(int[] nums) {
        List<Integer> st = new ArrayList<>();
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            if(st.isEmpty() || nums[st.get(st.size() - 1)] > a){
                st.add(i);
            }else{
                int l = 0, h = st.size() - 1;
                int res = l;
                while (l <= h){
                    int m = l + (h - l) / 2;
                    if(nums[st.get(m)] > a){
                        l = m + 1;
                    }else{
                        res = m;
                        h = m - 1;
                    }
                }
                ans = Math.max(ans, i - st.get(res));
            }
        }
        return ans;
    }
}
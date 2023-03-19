class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        helper(0, nums, k, new ArrayList<>());
        return ans;
    }

    int ans = 0;
    public void helper(int idx, int[] nums, int k, List<Integer> list){
        int n = nums.length;
        if(idx == n){
            if(list.size() > 0){
                ans += 1;
            }
            return;
        }
       if(!list.contains(nums[idx] - k)){
            list.add(nums[idx]);
            helper(idx + 1, nums, k, list);
            list.remove(list.size() - 1);
        }
        helper(idx + 1, nums, k, list );
    }

}
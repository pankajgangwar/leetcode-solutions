class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int i = 0, added = 0;;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                added++;
            }
        }
        return added;
    }
    /*
    
    int minPatches(vector<int>& nums, int n) {
        long miss = 1, added = 0, i = 0;
        while (miss <= n) {
            if (i < nums.size() && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                added++;
            }
        }
        return added;
    }
    
    */
}
class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (i < n && nums[i] == 0) i++;
            int j = i;
            while (j < n && nums[j] != 0)j++;

            if(i < j){
                int ne = 0;
                int first = -1;
                int last = -1;
                for (int k = i; k < j; k++) {
                    if(nums[k] < 0) {
                        ne++;
                        if(first == -1) first = k;
                        last = k;
                    }
                }
                if(ne % 2 == 0){
                    res = Math.max(res, j - i);
                }else{
                    // Max from first neg to j or i to last neg
                    res = Math.max(res, last - i);
                    res = Math.max(res, j - (first + 1));
                }
            }
            i = j;
        }
        return res;
    }
}
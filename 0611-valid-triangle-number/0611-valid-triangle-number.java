class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int res = 0;

        for(int i = 2; i < n ; i++){
            int start = 0;
            int end = i - 1;

            while(start < end){
                int a = nums[i];
                int b = nums[start];
                int c = nums[end];

                if(a < b + c){
                    res += end - start;
                    end--;
                }else{
                    start++;
                }
            }
        }
        return res;
    }
}
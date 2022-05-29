class Solution {
    /*
    * Monotone increasing stack
    * */
    public int totalSteps(int[] nums) {
        Stack<int[]> st = new Stack<>();
        int res = 0;
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if(st.isEmpty() || st.peek()[0] >= nums[i]){
                st.push(new int[]{nums[i], 0});
            }else{
                int count = 0;
                while (!st.isEmpty() && st.peek()[0] < nums[i]){
                    count += 1;
                    int[] temp = st.pop();
                    if(count < temp[1]) count += (temp[1] - count);
                }
                st.push(new int[]{nums[i], count});
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
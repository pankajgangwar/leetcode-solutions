class Solution {
    public int validSubarrays(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }
            st.push(i);
            ans += st.size();
        }
        
        /*int ans = n;
        System.out.println(st);
        
        while(!st.isEmpty()){
            ans += (n - st.pop()) - 1;
        }*/
        
        return ans;
    }
}
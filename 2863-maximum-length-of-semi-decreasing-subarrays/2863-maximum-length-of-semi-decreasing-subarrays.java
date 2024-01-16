class Solution {
    
    public int maxSubarrayLength(int[] nums){
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if(st.isEmpty() || nums[st.peek()] < nums[i]) st.push(i);
        }
        int res = 0;
        for (int i = nums.length - 1; i >=0; i--) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]){
                res = Math.max(res, i - st.pop() + 1);
            }
        }
        return res;
    }
    
    public int maxSubarrayLength1(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            Integer higher =  map.higherKey(nums[i]);
            if(higher == null){
                if(!map.containsKey(nums[i])){
                    map.put(nums[i], i);
                }
            }else{
                System.out.println("ele " + nums[i] + " higher " + higher);
                res = Math.max(res, i - map.get(higher) + 1);
            }
        }
        return res;
    }
}
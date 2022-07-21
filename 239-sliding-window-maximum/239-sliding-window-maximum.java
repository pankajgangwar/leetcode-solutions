class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return maxSlidingWindowUsingDeque(nums, k);
    }

    public int[] maxSlidingWindowUsingDeque(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return new int[0];
        
        int[] result = new int[n - k + 1];
        
        int ri = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            while(!dq.isEmpty() && dq.peekFirst() < i - k + 1){
                dq.pollFirst();//Remove index out of window
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            if(i >= k -1){
                result[ri++] = nums[dq.peekFirst()];
            }

        }
        return result;
    }
}
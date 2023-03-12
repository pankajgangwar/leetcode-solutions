class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        Stack<Integer> lStack = new Stack<>();
        Stack<Integer> rStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while(!lStack.isEmpty() && nums[i] <= nums[lStack.peek()]){
                lStack.pop();
            }
            l[i] = lStack.isEmpty() ? 0 : lStack.peek() + 1;
            lStack.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            while(!rStack.isEmpty() && nums[i] <= nums[rStack.peek()]){
                rStack.pop();
            }
            r[i] = rStack.isEmpty() ? n - 1 : rStack.peek() - 1;
            rStack.push(i);
        }
        for (int i = 0; i < n; i++) {
            int left = l[i];
            int right = r[i];
            int len = right - left + 1;
            if(threshold / len < nums[i]){
                return len;
            }
        }
        return -1;
    }
}
class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long res = 0;
        int j, k;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && nums[s.peek()] > ( i== n ? Integer.MIN_VALUE : nums[i])){
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res -= (long) nums[j] * (i - j) * (j - k);// total subarrays where nums[j] is max
            }
            s.push(i);
        }

        s.clear();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && nums[s.peek()] < ( i == n ? Integer.MAX_VALUE : nums[i])){
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res += (long) nums[j] * (i - j) *( j - k); // total subarrays where nums[j] is min
            }
            s.push(i);
        }
        return res;        
    }
}
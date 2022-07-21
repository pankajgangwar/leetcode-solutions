class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int start = 0;
        Deque<Integer> mindq = new ArrayDeque<>();
        Deque<Integer> maxdq = new ArrayDeque<>();
        int end = 0;
        for (; end < nums.length ; end++) {
            while (!mindq.isEmpty() && mindq.peekLast() > nums[end]) mindq.pollLast();
            while (!maxdq.isEmpty() && maxdq.peekLast() < nums[end]) maxdq.pollLast();

            mindq.offer(nums[end]);
            maxdq.offer(nums[end]);

            if (maxdq.peekFirst() - mindq.peekFirst() > limit) {
                if(maxdq.peekFirst() == nums[start]) maxdq.pollFirst();
                if(mindq.peekFirst() == nums[start]) mindq.pollFirst();
                ++start;
            }
        }
        return end - start;
    }
}
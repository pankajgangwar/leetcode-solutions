class Solution {
    
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0, j = 0;
        for (; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.lastKey() - map.firstKey() > limit){
                 map.put(nums[j], map.get(nums[j]) - 1);
                if(map.get(nums[j]) == 0) map.remove(nums[j]);
                j++;
            }
        }
        return i - j;
    }
    
    public int longestSubarrayDeque(int[] nums, int limit) {
        int start = 0;
        Deque<Integer> mindq = new ArrayDeque<>();
        Deque<Integer> maxdq = new ArrayDeque<>();
        int end = 0;
        for (; end < nums.length ; end++) {
            while (!mindq.isEmpty() && mindq.peekLast() > nums[end]) mindq.pollLast();
            while (!maxdq.isEmpty() && maxdq.peekLast() < nums[end]) maxdq.pollLast();

            mindq.addLast(nums[end]);
            maxdq.addLast(nums[end]);

            if (maxdq.peekFirst() - mindq.peekFirst() > limit) {
                if(maxdq.peekFirst() == nums[start]) maxdq.pollFirst();
                if(mindq.peekFirst() == nums[start]) mindq.pollFirst();
                ++start;
            }
        }
        return end - start;
    }
}
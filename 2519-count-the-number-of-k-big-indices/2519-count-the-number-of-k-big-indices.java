class Solution {
    public int kBigIndices(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        int n = nums.length;
        boolean[] prefix = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(maxHeap.size() == k && maxHeap.peek() < nums[i]){
                prefix[i] = true;
            }
            maxHeap.offer(nums[i]);
            if(maxHeap.size() > k) maxHeap.poll();
        }
        maxHeap.clear();
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if(maxHeap.size() == k && maxHeap.peek() < nums[i] && prefix[i]){
                ans += 1;
            }
            maxHeap.offer(nums[i]);
            if(maxHeap.size() > k) maxHeap.poll();
        }
        return ans;
    }
}
class Solution {
    public long kSum(int[] nums, int k) {
        long maxSum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int a = nums[i];
            if(a >= 0){
                maxSum += a;
            }else {
                nums[i] = -nums[i];
            }
        }
        Arrays.sort(nums);

        PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        minHeap.offer(new long[]{nums[0], 0});

        List<Long> sub = new ArrayList<>();
        sub.add(0L);
        
        while (!minHeap.isEmpty() && sub.size() < k){
            long[] curr = minHeap.poll();
            sub.add(curr[0]);
            int idx = (int) curr[1];
            if(idx < n - 1){
                minHeap.offer(new long[]{curr[0] + nums[idx + 1], idx + 1});
                minHeap.offer(new long[]{(curr[0] - nums[idx]) + nums[idx + 1], idx + 1});
            }
        }
        return maxSum - sub.get(k - 1);
    }
}
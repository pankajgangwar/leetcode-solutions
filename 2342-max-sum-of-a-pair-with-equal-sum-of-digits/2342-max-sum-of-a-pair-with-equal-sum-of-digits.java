class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            int sum = getSum(nums[i]);
            map.putIfAbsent(sum, new PriorityQueue<>((a,b) -> b - a));
            map.get(sum).offer(nums[i]);
        }
        for(Map.Entry<Integer, PriorityQueue<Integer>> e : map.entrySet()){
            int sum = e.getKey();
            PriorityQueue<Integer> heap = e.getValue();
            if(heap.size() >= 2){
                int a = heap.poll();
                int b = heap.poll();
                max = Math.max(max, a + b);
            }
        }
        return max;
    }

    public int getSum(int digit){
        int sum = 0;
        while (digit != 0){
             sum += digit  % 10;
            digit = digit / 10;
        }
        return sum;
    }
}
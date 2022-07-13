class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int j = 0; j < nums.length ; j++) {
            pq.offer(new int[]{j, nums[j]});
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<int[]> list = new ArrayList<>();
        while(!pq.isEmpty()){
            int[] a = pq.poll();
            list.add(new int[]{a[0], a[1]});
        }
        list.sort(Comparator.comparingInt(a -> a[0]));
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i)[1];
        }
        return res;
    }
}
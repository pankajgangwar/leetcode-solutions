class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
       long sum = Arrays.stream(nums).summaryStatistics().getSum();
        //System.out.println("********  sum *******" + sum);
        HashSet<Integer> marked = new HashSet<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});

        }
        long[] res = new long[queries.length];
        for(int i = 0; i < queries.length; i++){
            int[] q = queries[i];
            int idx = q[0];
            int k = q[1];
            if(marked.add(idx)){
                sum -= nums[idx];
            }
            while (!pq.isEmpty() && k-- > 0){
                int[] p = pq.poll();
                //System.out.println(Arrays.toString(p));
                if(marked.add(p[1])){
                    //System.out.println("Removing " + nums[p[1]] + " from " + sum);
                    sum -= nums[p[1]];
                    //System.out.println("Remaining " + sum);
                }else{
                    k++;
                }
            }
             //System.out.println("***************");
            for (int[] ints : pq) {
                //System.out.println(Arrays.toString(ints));
            }
            res[i] = sum;
        }
        return res; 
    }
}
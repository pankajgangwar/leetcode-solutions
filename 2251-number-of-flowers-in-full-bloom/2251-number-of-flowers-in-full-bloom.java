class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int p = people.length;
        int[] ans = new int[p];
        for (int[] flower : flowers) {
            pq.offer(new int[]{flower[0], 0});
            pq.offer(new int[]{flower[1], 2});
        }
        for (int i = 0; i < people.length; i++) {
            pq.offer(new int[]{people[i], 1, i});
        }
        int count = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if(curr[1] == 0){
                count++;
            }else if(curr[1] == 1){
                ans[curr[2]] = count;
            }else{
                count--;
            }
        }
        return ans;
    }
}
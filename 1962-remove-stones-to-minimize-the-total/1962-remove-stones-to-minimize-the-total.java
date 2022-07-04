class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : piles){
            pq.offer(x);
        }
        while (k-- > 0){
            int x = pq.poll();
            int ans = 0;
            if(x % 2 !=0 ){
                ans = Math.floorDiv(x, 2) + 1;    
            }else{
                ans = x / 2;
            }
            
           // int ans = (int)Math.floor((double)x / 2);
           // System.out.println("ans " + ans + " x " + x);
            pq.offer(ans);
        }
        int sum = 0;
        while (!pq.isEmpty()){
            sum += pq.poll();
        }
        return sum;
    }
}
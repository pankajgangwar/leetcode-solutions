class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int m : amount){
            if(m > 0) pq.offer(m);
        }
        int sec = 0;
        while (!pq.isEmpty()){
            int size = pq.size();
            if(size == 1){
                sec += pq.poll() - 1;
                
            }else{
                int a = pq.poll() - 1;
                int b = pq.poll() - 1;
                if(a > 0) pq.offer(a);
                if(b > 0) pq.offer(b);
            }
            sec++;
        }
        return sec;
    }
}
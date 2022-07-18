class Solution {
    public int getKth(int lo, int hi, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? -a[1] + b[1] : -a[0] + b[0]);
        for (int i = lo; i <= hi; i++) {
            pq.offer(new int[]{getPower(i), i});
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek()[1];
    }

     HashMap<Integer, Integer> memo = new HashMap<>();
    public int getPower(int n){
        if(n == 1 ) return n;
        if(memo.containsKey(n)) return memo.get(n);
        int res = 0;
        if(n % 2 == 0){
             res = 1 + getPower(n / 2);
        }else{
            res = 1 + getPower(3 * n + 1);
        }
        memo.put(n, res);
        return memo.get(n);
    }
}
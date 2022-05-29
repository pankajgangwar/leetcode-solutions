class Solution {
    
    public int findTheWinner(int n, int k) {
        //return josephusIterative(n, k);
        return josephus(n, k);
    }
    
    int josephusIterative(int n, int k) {
        int res = 0;
        for (int i = 1; i <= n; ++i)
            res = (res + k) % i;
        return res + 1;
    }

    int josephus(int n, int k) {
        return n > 1 ? (josephus(n - 1, k) + k - 1) % n + 1 : 1;
    }
    
    public int findTheWinner1(int n, int k) {
         LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        int start = 0;
        int end = start + k - 1;
        while (queue.size() > 1){
            queue.remove(end);
            start = end;
            end = (start + k - 1) % queue.size() ;
        }
        return queue.poll();
    }
}
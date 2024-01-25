class Solution {
    public int shortestSubarray(int[] arr, int k) {
        int n = arr.length;
        long[] prefixSum = new long[n+1];
        int res = n + 1;

        for(int i = 0; i < n; i++) {
            prefixSum[i+1] = prefixSum[i] + arr[i];
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n+1; i++) {
            while(!dq.isEmpty() && prefixSum[i] - prefixSum[dq.peekFirst()] >= k)
                res = Math.min(res, i - dq.pollFirst());

            while(!dq.isEmpty() && prefixSum[i] <= prefixSum[dq.peekLast()])
                dq.pollLast();

            dq.addLast(i);
        }

        return res <= n ? res : -1;
    }
}
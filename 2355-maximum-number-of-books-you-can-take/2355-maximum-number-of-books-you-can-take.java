class Solution {
    public long getSum(int n){
        if(n < 0) return 0;
        return (long) n * (n + 1) / 2;
    }
    
    public long maximumBooks(int[] books) {
        Stack<Integer> stack = new Stack<>();
        int n = books.length;
        long[] dp = new long[n];
        long maxBooks = 0;
        for(int i = 0; i < n; i++){
            while (!stack.isEmpty() && books[stack.peek()] >= books[i] - i + stack.peek()){
                stack.pop();
            }
            dp[i] = (stack.isEmpty() ? 0 : dp[stack.peek()]) +
                    getSum(books[i]) - getSum(books[i] - i + (stack.isEmpty() ? -1 : stack.peek()));

            maxBooks = Math.max(maxBooks, dp[i]);
            stack.push(i);
        }
        return maxBooks;
    }
}
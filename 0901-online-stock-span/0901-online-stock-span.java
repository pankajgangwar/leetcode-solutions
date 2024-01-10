class StockSpanner {
    /**
    Similar problem:
    https://leetcode.com/problems/next-greater-element-ii/
    https://leetcode.com/problems/daily-temperatures/
    
    */
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int len = 0;
        int span = 1;
        int[] curr = new int[]{price, span};
        
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            span += stack.pop()[1];
        }
        curr[1] = span;
        stack.push(curr);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(Integer.MAX_VALUE);
        
        int res = 0;
        for(int a : arr){
            while(stack.peek() <= a){
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        
        while(stack.size() > 2){
            res = res + stack.pop() * stack.peek();
        }
        
        return res;
    }
}
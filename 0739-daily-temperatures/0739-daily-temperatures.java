class Solution {
    /**
    Similar problem:
    https://leetcode.com/problems/next-greater-element-ii/
    https://leetcode.com/problems/online-stock-span/
    
    */
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
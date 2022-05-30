class Solution {
    public int[] canSeePersonsCount(int[] h) {
        int n = h.length;
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        for(int i = n - 1; i >=0 ; i--){
            int count = 0;
            while(!stack.isEmpty() && h[i] > stack.peek()[0]){
                count++;
                stack.pop();
            }
            res[i] = count + (stack.isEmpty() ? 0 : 1);
            stack.push(new int[]{h[i], i});
        }
        return res;
    }
}
class Solution {
    public int evalRPN(String [] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];
            if(curr.equals("+")){
                int prev1 = stack.pop();
                int prev2 = stack.pop();
                int res = prev1 + prev2;
                stack.push(res);
            }else if(curr.equals("-")){
                int prev2 = stack.pop();
                int prev1 = stack.pop();
                int res = prev1 - prev2;
                stack.push(res);
            }else if(curr.equals("*")){
                int prev2 = stack.pop();
                int prev1 = stack.pop();
                int res = prev1 * prev2;
                stack.push(res);
            }else if(curr.equals("/")){
                int prev2 = stack.pop();
                int prev1 = stack.pop();
                int res = prev1 / prev2;
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

}
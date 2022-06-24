class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> mStack = new Stack<Integer>();
        int n = s.length();
        int longestValid = 0;
        char[] arr = s.toCharArray();
        for(int i = 0; i < n; ++i){
            if(arr[i] == '('){
                mStack.push(i);
            }else{
                if(!mStack.isEmpty()){
                    if(arr[mStack.peek()] == '(' )
                        mStack.pop();
                    else
                        mStack.push(i);
                }else{
                    mStack.push(i);
                }
            }
        }

        if(mStack.isEmpty()) return n;

        int a = n, b = 0;
        while(!mStack.isEmpty()){
            b = mStack.pop();
            longestValid = Math.max(longestValid, a - b -1);
            a = b;
        }
        longestValid = Math.max(longestValid, a );

        return longestValid;
    }
}
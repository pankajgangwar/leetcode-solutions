class Solution {
    public int[] asteroidCollision1(int[] asteroids) {
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] < 0 && !st.isEmpty() && st.peek() > 0){
                int prev = st.pop();
                if(prev != -asteroids[i]){
                    int rem = Math.max(prev, -asteroids[i]);
                    if(-asteroids[i] == rem){
                        rem = -rem;
                    }
                    st.push(rem);
                }
            }else{
                st.push(asteroids[i]);
            }
        }
        if(st.size() >= 2 && st.peek() < 0){
            int prev = st.pop();
            if(st.peek() > 0){
                if(-prev != st.peek()){
                    int rem = Math.max(-prev, st.peek());
                    if(-prev == rem){
                       rem = -rem;
                    }
                    st.pop();
                    st.push(rem);
                }else{
                    st.pop();
                }
            }else{
                st.push(prev);
            }
        }
        int[] ans = new int[st.size()];
        int i = st.size() - 1;
        while(!st.isEmpty()){
            ans[i--] = st.pop();
        }
        return ans;
    }
    
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack<>();
        for (int i :a ) {
            if(i > 0){
                stack.add(i);
            }else{
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -i)
                    stack.pop();
                if(!stack.isEmpty() && stack.peek() == -i)
                    stack.pop();
                else if(stack.isEmpty() || stack.peek() < 0)
                    stack.add(i);
            }
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}
class Solution {
    public boolean parseBoolExpr(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(arr[i] == ')'){
                HashSet<Character> seen = new HashSet<>();
                while (st.peek() != '('){
                    seen.add(st.pop());
                }
                st.pop();// remove (
                char op = st.pop();
                if(op == '|'){
                    st.push(seen.contains('t') ? 't' : 'f');
                }else if(op == '&'){
                    st.push(seen.contains('f') ? 'f' : 't');
                }else { // !
                    st.push(seen.contains('t') ? 'f' : 't');
                }
            }else if(arr[i] != ','){
                st.push(arr[i]);
            }
        }
        return st.peek() == 't';
    }
}
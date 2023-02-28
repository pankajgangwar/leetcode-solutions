class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder out = new StringBuilder(s);

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }else if(ch == ')'){
                if(!st.isEmpty()){
                    st.pop();    
                }else{
                    out.setCharAt(i, '*');
                }
            }
        }
        while(!st.isEmpty()){
            out.setCharAt(st.pop(), '*');
        }
        return out.toString().replaceAll("\\*", "");
    }
}
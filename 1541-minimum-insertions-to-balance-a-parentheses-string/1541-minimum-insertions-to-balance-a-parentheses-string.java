class Solution {
    public int minInsertions(String s){
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        int insertion = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push('(');
            }else {
                if(st.isEmpty()){
                    st.push('(');
                    insertion++;
                }
                if(i + 1 < s.length() && s.charAt(i + 1) == ')') i++;
                else insertion++;
                st.pop();
            }
        }
        return insertion + st.size() * 2;
    }
}
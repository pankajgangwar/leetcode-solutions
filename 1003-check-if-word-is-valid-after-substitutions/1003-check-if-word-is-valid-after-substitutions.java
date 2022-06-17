class Solution {
    public boolean isValid1(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == 'c'){
                if(st.isEmpty() || st.pop() != 'b') return false;
                if(st.isEmpty() || st.pop() != 'a') return false;
            }else{
                st.push(ch);
            }
        }
        return st.isEmpty();
    }
    
    public boolean isValid(String s) {
        String p = "abc";
        StringBuilder sb = new StringBuilder(s);
        while (sb.indexOf(p) >= 0){
            int idx = sb.indexOf(p);
            sb.delete(idx, idx + p.length());
        }
        return sb.length() == 0;
    }
}
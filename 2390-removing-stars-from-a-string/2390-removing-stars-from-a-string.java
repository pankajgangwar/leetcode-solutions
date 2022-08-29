class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*' && !st.isEmpty()){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder out = new StringBuilder();
        for(char ch : st){
            out.append(ch);
        }
        return out.toString();  
    }
}
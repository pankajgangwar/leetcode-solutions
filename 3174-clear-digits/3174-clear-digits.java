class Solution {
    public String clearDigits(String s) {
        StringBuilder out = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                if(!st.isEmpty()){
                    out.setCharAt(st.pop(), '*');
                }
                out.setCharAt(i, '*');
            }else{
                st.push(i);
            }
        }
        return out.toString().replaceAll("\\*", "");
    }
}
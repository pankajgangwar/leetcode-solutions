class Solution {
    public int minSwaps(String s) {
        Stack<Integer> st = new Stack<Integer>();
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '['){
                st.push(i);
            }else if(sb.charAt(i) == ']'){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
        }
        int size = st.size();
        if(size == 0) return size;
        return size % 2 == 0 ? size / 2 : (size / 2) + 1;
    }
}
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();
        
        int count = 0;
        for(char ch : arr){
            if(ch == '(') st.push(ch);
            else if(!st.isEmpty()) st.pop();
            else ++count;
        }
        return count + st.size();
    }
}
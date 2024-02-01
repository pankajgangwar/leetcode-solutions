class Solution {

    public int calculate(String s) {
        
        Stack<Integer> st = new Stack<>();
        char sign = '+';
        int digit = 0;
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                digit = digit * 10 + (ch - '0');
            }
            if(ch == '(') {
                int count = 0;
                int j = i;
                for(; i < s.length(); i++ ){
                    if(s.charAt(i) == '(') ++count;
                    if(s.charAt(i) == ')') --count;
                    
                    if(count == 0) break;
                }
                String sub = s.substring(j + 1, i);
                digit = calculate(sub);
            }
            
            if((!Character.isDigit(ch) && ch != ' ') ||  i == s.length() - 1 ){
                if(sign == '+'){
                    st.push(digit);
                }else if(sign == '-'){
                    st.push(-digit);
                }else if(sign == '*'){
                    st.push(st.pop() * digit);                    
                }else if(sign == '/'){
                    st.push(st.pop() / digit);        
                }
                digit = 0;
                sign = ch;
            }
        }
        
        int ans = 0;
        for(int a : st){
            ans += a;
        }
        return ans;
    }
}
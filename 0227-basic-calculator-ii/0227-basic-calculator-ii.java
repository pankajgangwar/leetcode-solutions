class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int res = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + s.charAt(i) - '0';
            }
            if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length()-1) {
                if(sign == '+'){
                    stack.push(num);
                    num = 0;
                }else if(sign == '-'){
                    stack.push(-num);
                    num = 0;
                }else if(sign == '/'){
                    stack.push(stack.pop() / num);
                    num = 0;
                }else if(sign == '*'){
                    stack.push(stack.pop() * num);
                    num = 0;
                }
                sign = s.charAt(i);
            }
        }

        for (int ele : stack){
            res += ele;
        }
        return res;
    }
}
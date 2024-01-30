class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int res = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                number = 10 * number + (int)ch - '0';
            }else if(ch == '+'){
                res += sign* number;
                sign = 1;
                number = 0;
            }else if(ch == '-'){
                res += sign * number;
                sign = -1;
                number = 0;
            }else if(ch == '('){
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            }else if(ch == ')'){
                res += sign * number;
                number = 0;
                res = res * stack.pop();//sign
                res = res + stack.pop();//old result
            }
        }
        if(number != 0) res += sign * number;
        return res;
    }
}
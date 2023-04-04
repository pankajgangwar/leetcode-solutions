class Solution {
     public boolean isValid(String s) {
        if(s.length() == 0){
            return true;
        }
        Stack<Character> mStack = new Stack<>();
        for( char ch : s.toCharArray()){

            if(ch == '(' || ch == '{' || ch == '[')
                mStack.push(ch);

            if(ch == ')' || ch == '}' || ch == ']'){
                if(mStack.isEmpty())
                    return false;

                if(!isMatchingPair(mStack.pop(), ch))
                    return false;

            }
        }
        
        if(mStack.isEmpty())
            return true;
        else
            return false;
    }

    public boolean isMatchingPair(char first, char second){
        if(first == '(' && second == ')')
            return true;
        else if(first == '{' && second == '}')
            return true;
        else if (first == '[' && second == ']')
            return true;

        return false;
    }
}
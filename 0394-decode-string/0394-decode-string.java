class Solution {
    class IntegerRef{
        int val = 0;
        public IntegerRef(int ele){
            val = ele;
        }
    }
    public String decodeString(String s) {
        IntegerRef pos = new IntegerRef(0);
        return decodeStringRec(s, pos);
    }

    public String decodeStringRec(String s, IntegerRef idx) {
        StringBuilder builder = new StringBuilder();

        int num = 0;

        for(; idx.val < s.length(); idx.val++){
            char ch = s.charAt(idx.val);
            if(ch == '['){ // a - z
                idx.val++;
                String toAppend = decodeStringRec(s, idx);
                for(;num > 0; num--)
                    builder.append(toAppend);
                
            }else if(ch >= '0' && ch <= '9'){ // 1,2,3 , ..
                num = num*10 + ch - '0';
            }else if(ch == ']'){
                return builder.toString();
            }else{ // ']'
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}
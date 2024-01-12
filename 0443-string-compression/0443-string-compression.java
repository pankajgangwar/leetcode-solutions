class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        int count = 0;

        int resultIdx = 0;

        while(idx < chars.length ) {
            char curr_char = chars[idx];
            count = 0;
            while(idx < chars.length && chars[idx] == curr_char){
                idx++;
                count++;
            }
            if(count > 1){
                chars[resultIdx++] = curr_char;
                for( char ch : Integer.toString(count).toCharArray()){
                    chars[resultIdx++] = ch;
                }
            }else{
                chars[resultIdx++] = curr_char;
            }
        }
        return resultIdx;
    }
}
class Solution {
    public String[] splitMessage(String message, int limit) {
        int b = 0, curr = 0;
        int n = message.length();
        while (len(b) * 2 + 3 < limit && curr + n + (3 + len(b)) * b > limit * b ){
            b++;
            curr += len(b);
        }
        String[] res = new String[0];
        if(len(b) * 2 + 3 < limit){
            int pos = 0;
            res = new String[b];
            for (int i = 1; i <= b ; i++) {
                StringBuilder out = new StringBuilder();
                int readLen = limit - ( 3 + len(i) + len(b));
                String s = message.substring(pos, Math.min(pos + readLen, n ) );
                out.append(s);
                out.append("<").append(i).append("/").append(b).append(">");
                res[i-1] = out.toString();
                pos += readLen;
            }
        }
        return res;
    }

    public int len(int a){
        return String.valueOf(a).length();
    }

}
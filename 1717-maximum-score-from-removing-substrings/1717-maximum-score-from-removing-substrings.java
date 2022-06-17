class Solution {
    public int maximumGain(String s, int x, int y) {
        String a = "ab";
        String b = "ba";
        int n = s.length();
        if(n <= 2){
            if(s.equals(a)) return x;
            if(s.equals(b)) return y;
            return 0;
        }
        StringBuilder sb = new StringBuilder(s);
        if(x < y) {
            return remove(sb, b, y) + remove(sb, a, x);
        }
        return remove(sb, a, x) + remove(sb, b, y);
    }

    public int remove(StringBuilder s, String p, int x) {
        int i = 0, res = 0;
        for(int j = 0; j < s.length(); j++){
            s.setCharAt(i++, s.charAt(j));
            if(i > 1 && s.charAt(i-2) == p.charAt(0) && s.charAt(i-1) == p.charAt(1)){
                i -= 2;
                res += x;
            }
        }
        s.setLength(i);
        return res;
    }

}
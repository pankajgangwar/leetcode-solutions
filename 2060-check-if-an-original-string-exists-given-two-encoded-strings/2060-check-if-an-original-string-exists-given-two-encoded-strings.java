class Solution {
        public boolean possiblyEquals(String s1, String s2) {
        return helper(0, 0, s1, s2, 0);
    }

    Boolean[][][] memo = new Boolean[41][41][2000];
    public boolean helper(int i, int j, String s1, String s2, int diff){
        int n1 = s1.length();
        int n2 = s2.length();
        if(i >= n1 && j >= n2 && diff == 0) return true;
        if(memo[i][j][diff + 1000] != null) return memo[i][j][diff + 1000];
        boolean res = false;
        if(i < n1){
            if(Character.isDigit(s1.charAt(i))){
                int count = 0, value = 0;
                while (i + count < n1 && count < 3 &&
                        Character.isDigit(s1.charAt(i + count))){
                    value = value * 10 + (s1.charAt(i + count) - '0');
                    count += 1;
                    if(helper(i + count, j, s1, s2, diff - value)) res = true;
                }
            }else{
                if(diff > 0){
                    if(helper(i + 1, j, s1, s2,diff - 1)) res = true;
                }else if(diff == 0 && j < n2 && s1.charAt(i) == s2.charAt(j)){
                    if(helper(i + 1, j + 1, s1, s2, diff)) res = true;
                }
            }
        }
        if (j < n2) {
            if (Character.isDigit(s2.charAt(j))) {
                int count = 0, value = 0;
                while (j + count < n2 && count < 3 &&
                        Character.isDigit(s2.charAt(j + count))) {
                    value = value * 10 + (s2.charAt(j + count) - '0');
                    count += 1;
                    if (helper(i, j + count, s1, s2, diff + value)) res = true;
                }
            } else if (diff < 0 && helper(i, j + 1, s1, s2, diff + 1)) {
                res = true;
            }
        }
        return memo[i][j][diff + 1000] = res;
    }
}
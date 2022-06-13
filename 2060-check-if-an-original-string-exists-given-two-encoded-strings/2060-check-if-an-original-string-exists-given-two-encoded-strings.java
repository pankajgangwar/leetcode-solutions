class Solution {
    String s1;
    String s2;
    Boolean[][][] memo = new Boolean[41][41][2000];
    public boolean possiblyEquals(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0, 0, s1, s2, 0); //s1 pointer, s1 pointer, digit difference
    }

    private boolean dfs(int i, int j, String s1, String s2, int diff) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (i >= n1 && j >= n2 && diff == 0) return true;
        if (memo[i][j][diff + 1000] != null) return memo[i][j][diff + 1000];
        boolean res = false;
        if (i < s1.length()) {
            if (Character.isDigit(s1.charAt(i))) {
                int count = 0, value = 0; //be careful we can not change i cause s2 will use i again
                while (i + count < n1 && count < 3 && Character.isDigit(s1.charAt(i + count))) {
                    value = value * 10 + (s1.charAt(i + count) - '0');
                    count++;
                    if (dfs(i + count, j, s1, s2, diff - value)) res = true;
                }
            } else {
                if (diff > 0) {
                    if (dfs(i + 1, j, s1, s2, diff - 1)) res = true;
                } else if (diff == 0 && j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                    if (dfs(i + 1, j + 1, s1, s2, diff)) res = true;
                }
            }
        }
        if (j < s2.length()) {
            if (Character.isDigit(s2.charAt(j))) {
                int count = 0, value = 0;
                while (j + count < s2.length() && count < 3 && Character.isDigit(s2.charAt(j + count))) {
                    value = value * 10 + (s2.charAt(j + count) - '0');
                    count++;
                    if (dfs(i, j + count, s1, s2, diff + value)) res = true;
                }
            } else if (diff < 0 && dfs(i, j + 1, s1, s2, diff + 1)) res = true;
        }
        return memo[i][j][diff + 1000] = res;
    }
}
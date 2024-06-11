class Solution {
    
    public int strangePrinter(String s) {
        int n = s.length();
        List<Character> unique = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(i == 0){
                unique.add(s.charAt(i));
            }else if(unique.get(unique.size() - 1) != s.charAt(i)){
                unique.add(s.charAt(i));
            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < unique.size(); i++) {
            out.append(unique.get(i));
        }
        n = out.toString().length();
        int[][] memo = new int[n][n];
        return helper(0, n - 1, memo, out.toString());
    }
    public int helper(int i, int j, int[][] memo, String s){
        if(i > j) return 0;
        //if(i == j) return 1;
        if(memo[i][j] != 0) return memo[i][j];
        int min = 1 + helper(i + 1, j, memo, s);
        for(int m = i + 1; m <= j; m++){
            if(s.charAt(m) == s.charAt(i)){
                int sub_ans = helper(i, m - 1, memo, s) + helper(m + 1, j, memo, s);
                min = Math.min(min, sub_ans);
            }
        }
        return memo[i][j] = min;
    }
}
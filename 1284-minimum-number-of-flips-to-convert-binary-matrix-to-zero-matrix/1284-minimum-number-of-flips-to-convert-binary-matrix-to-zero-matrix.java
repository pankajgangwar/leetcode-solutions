class Solution {
    public int minFlips(int[][] mat) {
        int ans = convertMat(mat);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
    HashMap<String, Integer> dp = new HashMap<>();
    HashSet<String> seen = new HashSet<>();
    public int convertMat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        if(isZeroMatrix(mat)) return 0;
        String s = convertMatrixToString(mat);
        if(dp.containsKey(s)) return dp.get(s);
        if(seen.contains(s)) return Integer.MAX_VALUE;
        seen.add(s);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flipMatrix(mat, i, j);
                int res = convertMat(mat);
                if(res != Integer.MAX_VALUE) {
                    min = Math.min(min, res + 1);
                }
                flipMatrix(mat, i, j);
            }
        }
        seen.remove(s);
        dp.put(s, min);
        return min;
    }

    public String convertMatrixToString(int[][] mat){
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < mat.length; i++) {
            out.append(Arrays.toString(mat[i]));
        }
        return out.toString();
    }

    public void flipMatrix(int[][] mat, int i, int j){
        int m = mat.length;
        int n = mat[0].length;
        mat[i][j] = mat[i][j] ^ 1;
        if(j > 0) mat[i][j - 1] = mat[i][j - 1] ^ 1;
        if(i > 0) mat[i - 1][j] = mat[i - 1][j] ^ 1;
        if(j + 1 < n) mat[i][j + 1] = mat[i][j + 1] ^ 1;
        if(i + 1 < m) mat[i + 1][j] = mat[i + 1][j] ^ 1;
    }

    public boolean isZeroMatrix(int[][] mat){
        int m = mat.length;
        for (int i = 0; i < m; i++) {
            if(!Arrays.stream(mat[i]).allMatch(t -> t == 0)){
                return false;
            }
        }
        return true;
    }
}
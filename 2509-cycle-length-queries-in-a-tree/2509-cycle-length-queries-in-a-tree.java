class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int u = q[0];
            int v = q[1];
            res[i]++;
            while (u != v){
                if(u > v){
                    u = u / 2;
                }else {
                    v = v / 2;
                }
                res[i]++;
            }
        }
        return res;
    }
}
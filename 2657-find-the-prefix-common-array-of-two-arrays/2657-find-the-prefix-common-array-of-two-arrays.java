class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] occ = new int[n + 1];
        int[] res = new int[n];
        for (int i = 0, common = 0; i < n; i++) {
            int a = A[i];
            int b = B[i];
            if(++occ[a] == 2){
                ++common;
            }
            if(++occ[b] == 2){
                ++common;
            }
            res[i] = common;
        }
        return res;
    }
}
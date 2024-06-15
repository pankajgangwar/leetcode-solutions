class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int i = 0, j = n - 1;
        int[] result = new int[A.length];
		for (int p = n - 1; p >= 0; --p) {
            if(Math.abs(A[i]) > Math.abs(A[j])) { 
                result[p] = A[i] * A[i];
                i++;
            }else{
                result[p] = A[j] * A[j];
                j--;
            }
		}
		return result;
    }
}
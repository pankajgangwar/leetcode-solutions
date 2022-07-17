class Solution {
    public int minOperations(int[] A, int[] numsDivide) {
        int g = numsDivide[0];
        for (int n : numsDivide) {
            g = gcd(g, n);
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length && A[i] <= g; i++) {
            if(g % A[i] == 0) return i;
        }
        return -1;
    }


    private int gcd(int a, int b) {
        if(a == 0){
            return b;
        }
        return gcd(b % a, a);
    }
}
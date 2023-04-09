class Solution {
    
    boolean[] sieve = new boolean[4000001];
    public void buildSieve(){
        sieve[0] = sieve[1] = true;
        for (int p = 2; p*p <= 4000001 ; p++) {
            if(!sieve[p]){
                for (int i = p*p; i < 4000001; i += p) {
                    sieve[i] = true;
                }
            }
        }
    }
    
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int max = 0;
        buildSieve();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j){
                    int diag = nums[i][i];
                    if(!sieve[diag]){
                        max = Math.max(max, diag);
                    }
                }
                if(j == (n - i - 1)){
                    int antiDiag = nums[i][n - i - 1];
                    if(!sieve[antiDiag]){
                        max = Math.max(max, antiDiag);
                    }
                }
            }
        }
        return max;
    }
    
    public int diagonalPrime1(int[][] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j){
                    int diag = nums[i][i];
                    if(isPrime(diag)){
                        max = Math.max(max, diag);
                    }
                }
                if(j == (n - i - 1)){
                    int antiDiag = nums[i][n - i - 1];
                    if(isPrime(antiDiag)){
                        max = Math.max(max, antiDiag);
                    }
                }
            }
        }
        return max;
    }

    HashMap<Integer,Boolean> map = new HashMap<>();
    boolean isPrime(int n) {
        if(n<=1) return false;
        for(int i=2;i<=Math.sqrt(n);i++) {
            if((n%i)==0) return false;
        }
        return true;
    }

}
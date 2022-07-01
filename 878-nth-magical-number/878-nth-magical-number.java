class Solution {
    public int nthMagicalNumber(int n, int A, int B) {
        long low = 1;
        long high = (long)1e14;
        long gcd = gcd(A, B);
        long lcm = (A*B) / gcd;
        long mod = (long)1e9+7;

        while (low < high){
            long mid = (low + high) / 2;
            if((mid / A + mid / B - (mid / lcm)) < n ){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return (int)(low%mod);
    }
    
    public long gcd(int a, int b){
        if(b == 0) return (long)a;
        return gcd(b,a % b);
    }

}
import java.math.BigInteger;
class Solution {
    public boolean isReachable(int x, int y) {
        int n = BigInteger.valueOf(x).gcd(BigInteger.valueOf(y)).intValue();
        //return (n & (n-1)) == 0;//Brian Kernighan’s algorithm
        //return (n == (n & -n)); // check lowest bit
        return BigInteger.valueOf(n).bitCount() == 1;
    }
}
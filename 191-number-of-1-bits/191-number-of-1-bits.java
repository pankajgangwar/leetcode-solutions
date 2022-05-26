public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for(int i = 1; i <= 32; i++){
            res += (n >>> i) & 1;
        }
        /*while(n != 0){
            res += (n & 1);
            n = n >>> 1;
        }*/
        return res;
        //return Integer.bitCount(n);
    }
}
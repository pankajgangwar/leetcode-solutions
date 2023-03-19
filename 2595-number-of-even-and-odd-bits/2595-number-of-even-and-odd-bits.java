class Solution {
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        
        /*boolean isEven = true;
        while (n > 0){
            res[isEven ? 0 : 1] += (n & 1);
            n = n >> 1;
            isEven = !isEven;
        }*/
        
        for(int i = 0; i < 32; i++){
            res[i%2] += (n >> i) & 1;
        }
        return res;
    }
}
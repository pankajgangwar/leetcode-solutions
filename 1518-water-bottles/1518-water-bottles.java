class Solution {
    public int numWaterBottles(int n, int ne) {
        int d = 0;
        while(n >= ne){
            d += ne;
            n = n - ne + 1;
        }
        d += n;
        return d;
    }
    public int numWaterBottlesI(int n, int ne) {
        int ret = n;
        while (n >= ne) {
           int rem = n % ne;
           n = n / ne;
           ret += n; 
           n += rem;
        }
        return ret;
    }
}
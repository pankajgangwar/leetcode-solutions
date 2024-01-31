import java.math.BigInteger;

class Solution {
    public long countPairs(int[] nums, int k) {
        HashMap<Long, Long> cnt = new HashMap<>();
        for(int a : nums){
            cnt.merge(BigInteger.valueOf(a).gcd(BigInteger.valueOf(k)).longValue(), 1L, Long::sum);
        }
        long res = 0;
        for(long x : cnt.keySet()){
            for(long y : cnt.keySet()){
                if(x <=y && x * y % k == 0L ){
                    res += x < y ? cnt.get(x) * cnt.get(y) : cnt.get(x) * ( cnt.get(x) - 1L) / 2L;
                }
            }
        }
        return res;
    }
}
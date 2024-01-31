import java.math.BigInteger;

class Solution {
    public long countPairs(int[] nums, int k) {
        HashMap<Long, Long> cnt = new HashMap<>();
        for(int a : nums){
            long key = BigInteger.valueOf(a).gcd(BigInteger.valueOf(k)).longValue();
            cnt.put(key, cnt.getOrDefault(key, 0l) + 1l);
            //cnt.merge(key, 1l, Long::sum);
        }
        System.out.println(cnt);
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
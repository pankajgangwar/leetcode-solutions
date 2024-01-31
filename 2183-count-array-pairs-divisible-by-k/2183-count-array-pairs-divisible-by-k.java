import java.math.BigInteger;

class Solution {
    public long countPairs(int[] nums, int k) {
        HashMap<Long, Long> cnt = new HashMap<>();
        long res = 0;
        for(int a : nums){
            long key = BigInteger.valueOf(a).gcd(BigInteger.valueOf(k)).longValue();
            
            for(long x : cnt.keySet()){
                long count = cnt.get(x);
                if(x * a % k == 0L ){
                    res += count;
                }
            }
            cnt.put(key, cnt.getOrDefault(key, 0l) + 1l);
        }
        
        return res;
    }
}
class Solution {
        public int maxSum(List<Integer> nums, int k) {
        int mod = (int)1e9 + 7;
        HashMap<Integer,Integer> map = new HashMap<>();
        long p = 0;
        for(int val : nums){
            int i = 1;
            while(val>0){
                if(val%2==1){
                    map.put(i, map.getOrDefault(i, 0) + 1);
                    if(p<i) p = i;
                }
                val/=2;
                i*=2;
            }
        }
        long result = 0;
        while(k-- > 0){
            long x = 0;
            for(int i = 1;i <= p; i *= 2){
                int val = map.getOrDefault(i, 0);
                if(val > 0){
                    map.put(i, val - 1);
                    x += i;
                }
            }
            result += (x*x);
            result %= mod;
        }
        return (int)result;
    }
}
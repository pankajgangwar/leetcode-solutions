class Solution {
    int[] primes = new int[]{2,3,5,7,11,13,17,19,23,29};
    /**
   from question, 
   maximum array size is 1000 
   size of primes number less than 30 is eleven because == 10 + plus prime number one
   1 + {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};    
   **/
    Long[][] dp = new Long[1000][1<<11];
    int mod = (int) 1e9 + 7;
    public int squareFreeSubsets(int[] nums) {
        //all numbers divisible by 1, hence mask starts with 1
        return (int) f(nums, 0, 1, dp) - 1;// -1 for all zero case
    }

    private int getMask(long num){
        int mask = 0;
        for(int i = 0; i < primes.length; i++){
            int cnt = 0;
            while(num % primes[i] == 0){
                num /= primes[i];
                cnt++;
            }
            if(cnt > 1) return -1;
            if(cnt == 1){
                mask |= (1 << (i+1));
            }
        }
        return mask;
    }

    private long f(int[] nums, int idx, int mask, Long[][] memo){
        int n = nums.length;
        if(idx == n) return 1;
        if(memo[idx][mask] != null) return memo[idx][mask];
        //not select current index number
        long ans = f(nums, idx + 1, mask, memo) % mod;
        int m = getMask(nums[idx]);
        //if there's no common bit, i.e square free
        if(m != -1 && (mask & m) == 0){
            //select current idx
            ans = (ans + f(nums, idx + 1, mask | m, memo)) % mod;
        }
        return memo[idx][mask] = (ans % mod);
    }
}
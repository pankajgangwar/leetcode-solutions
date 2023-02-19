class Solution {
    int[] primes = new int[]{2,3,5,7,11,13,17,19,23,29};
    /**
     from question,
     maximum array size is 1000
     size of primes number less than 30 is eleven because == 10 + plus prime number one
     1 + {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
     **/
    Long[][] dp = new Long[1111][1<<11];
    int mod = (int) 1e9 + 7;
    public int squareFreeSubsets(int[] nums) {
        //all numbers divisible by 1, hence mask starts with 1
        return (int) f(nums, 0, 1) - 1;// -1 for all zero case i.e when we have not taken any number
    }

    private int getMask(long num){
        int mask = 0;
        for(int i = 0; i < primes.length; i++){
            int cnt = 0;
            while(num % primes[i] == 0){
                num /= primes[i];
                cnt++;
            }
            // if a number is getting divided with a prime more than 1 time meaning it can be divided by that primes square
            if(cnt > 1) return -1;
            if(cnt == 1){
                // i + 1 because the for i == 0 product 1 has already been taken
                mask |= (1 << (i+1));
            }
        }
        return mask;
    }

    private long f(int[] nums, int idx, int prodMask){
        int n = nums.length;
        if(idx == n) return 1;
        if(dp[idx][prodMask] != null) return dp[idx][prodMask];
        //not select current index number
        long ans = f(nums, idx + 1, prodMask) % mod;
        int mask = getMask(nums[idx]);
        //if there's no common bit, i.e square free
        if(mask != -1 && (prodMask & mask) == 0){
            //select current idx
            ans = (ans + f(nums, idx + 1, prodMask | mask)) % mod;
        }
        return dp[idx][prodMask] = (ans % mod);
    }
}
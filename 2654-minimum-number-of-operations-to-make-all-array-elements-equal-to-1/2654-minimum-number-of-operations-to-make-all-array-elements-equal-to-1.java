class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int a : nums){ if(a == 1) count++;}
        if(count > 0){ return n - count;}
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int last = nums[i];
            for (int j = i + 1; j < n; j++) {
                last = gcd(last, nums[j]);
                if(last == 1){
                    res = Math.min (res, (j - i) + (n - 1));
                    break;
                }
            }
        }
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }
    
    int gcd(int a, int b){return (b==0)?a:gcd(b,a%b);}
}
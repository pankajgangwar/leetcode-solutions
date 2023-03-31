class Solution {
    public int lengthOfLISDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }
        
        for(int i = 0; i< n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
    
    public int lengthOfLIS(int[] nums) {
        //return lengthOfLISDP(nums);
        return lengthOfLISPatienceSort(nums);
    }
    
    
     public int lengthOfLISPatienceSort(int[] nums) {
        List<Integer> piles = new ArrayList<>(nums.length);
        for (int num : nums) {
            int pile = Collections.binarySearch(piles, num);
            if (pile < 0) {
                pile = ~pile;//Bitwise unary NOT, Bitwise Complement
            }
            if (pile == piles.size()) {
                piles.add(num);
            } else {
                piles.set(pile, num);
            }
        }
        return piles.size();
    }
}
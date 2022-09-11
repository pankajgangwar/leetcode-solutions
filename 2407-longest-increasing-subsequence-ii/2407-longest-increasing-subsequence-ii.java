class Solution {
    
    public int lengthOfLIS(int[] nums, int k) {
        return lengthOfLISPatienceSort(nums, k);
    }
    public int lengthOfLISDP(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }

        for(int i = 0; i< n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && nums[i] - nums[j] <= k){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
    
    public int lengthOfLISPatienceSort(int[] nums, int k) {
        List<TreeSet<Integer>> piles = new ArrayList<>();
        int ans = 0;
        for (int num : nums) {
            int l = 0, r = piles.size() - 1;
            int idx = -1;
            while (l <= r){
                int m = l + (r - l) / 2;
                Integer smaller = piles.get(m).lower(num);
                if(smaller == null){
                    r = m - 1;
                }else if(smaller + k < num){
                    l = m + 1;
                }else{
                    idx = m;
                    l = m + 1;
                }
            }
            if(idx + 1 == piles.size()){
                piles.add(new TreeSet<>());
            }
            piles.get(idx + 1).add(num);
        }
        return piles.size();
    }
}
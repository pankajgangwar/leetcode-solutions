class Solution {
    public int minimumNumbers(int num, int k) {
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        for (int n = k; n <= num ; n++) {
            if(n % 10 == k){
                sum += n;
                res.add(n);
            }
        }
        if(sum == 0 && num == 0) return 0;
        int[] nums = res.stream().mapToInt(i -> i).toArray();
        //System.out.println(Arrays.toString(nums));
        int ans = coinChangeDP(nums, num, nums.length);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    public int coinChangeDP(int[] coins, int amount, int n) {
        int table[] = new int[ amount + 1];
        table[0] = 0;
        for (int i = 1; i <= amount; i++) {
            table[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= amount ; i++) {
            for (int j = 0; j < n; j++) {
                if(coins[j] <= i){
                    int sub_res = table[i - coins[j]];
                    if(sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i]){
                        table[i] = sub_res + 1;
                    }
                }
            }
        }
        return table[amount];
    }

}
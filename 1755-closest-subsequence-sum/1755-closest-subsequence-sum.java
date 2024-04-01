class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        generateSubsetSum(0, n / 2, nums, first, 0);
        generateSubsetSum(n/2, n, nums, second, 0);

        Collections.sort(first);
        Collections.sort(second);

        // (a+b) = sum
        // sum - goal -> minimize
        // (a+b) - goal
        // goal - b = a
        for(int b : second){
            int a = goal - b;
            if(first.get(0) > a){
                ans = Math.min(ans, Math.abs((first.get(0) + b) - goal));
                continue;
            }
            if(first.get(first.size() - 1) < a){
                ans = Math.min(ans, Math.abs((first.get(first.size() - 1) + b) - goal));
                continue;
            }
            int pos = Collections.binarySearch(first, a);
            if(pos >= 0){
                return 0;
            }
            pos = ~pos;
            ans = Math.min(ans, Math.abs((first.get(pos) + b) - goal));
            ans = Math.min(ans, Math.abs((first.get(pos - 1) + b) - goal));
        }
        return ans;
    }

    public void generateSubsetSum(int start, int end, 
                                  int[] nums, List<Integer> list, int sum){
        if(start == end) {
            list.add(sum);
            return;
        }
        generateSubsetSum(start + 1, end, nums, list, sum + nums[start]);
        generateSubsetSum(start + 1, end, nums, list, sum);
    }
}
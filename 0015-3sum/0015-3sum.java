class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1;
            int end = n - 1;

            while (start < end){
                int a = nums[i];
                int b = nums[start];
                int c = nums[end];

                int sum = a + b + c;
                if(sum == 0){
                    List<Integer> pairs = new ArrayList<>();
                    pairs.add(a);
                    pairs.add(b);
                    pairs.add(c);
                    result.add(pairs);
                    start++;
                    end--;
                }else if(sum > 0) {
                    end--;
                }else {
                    start++;
                }
            }
        }

        List<List<Integer>> final_res = new ArrayList<>();
        final_res.addAll(result);
        return final_res;
    }
}
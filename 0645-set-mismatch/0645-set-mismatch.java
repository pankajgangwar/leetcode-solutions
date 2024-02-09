class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int[] res = new int[2];
        for(int a : nums){
            if(!set.add(a)){
                res[0] = a;
                break;
            }
        }
        long actual = Arrays.stream(nums).sum();
        int n = nums.length;
        long sum = (long) n * (n + 1) / 2;
        int missing = (int)(sum - actual);
        res[1] = missing + res[0];
        return res;
    }
}
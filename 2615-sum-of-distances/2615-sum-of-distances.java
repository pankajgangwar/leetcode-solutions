class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // group indices by number value
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
            }
            map.get(num).add(i);
        }
        

        for (List<Integer> indices : map.values()) {
            int size = indices.size();
            if (size == 1) {
                ans[indices.get(0)] = 0;
            } else {
                long nextSum = indices.stream().mapToLong(i -> i).sum();
                long prevSum = 0;
                for (int i = 0; i < size; i++) {
                    int index = indices.get(i);
                    long tmp = nextSum - ((long) (size - i) * index);
                    tmp += Math.abs(prevSum - (long) i * index);
                    ans[index] = tmp;
                    nextSum -= index;
                    prevSum += index;
                }
            }
        }
        
        return ans;
    }
}
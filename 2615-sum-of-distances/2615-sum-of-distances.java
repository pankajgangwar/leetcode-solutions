class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        long[] arr = new long[n];
        for(List<Integer> indices : map.values()){
            int size = indices.size();
            if(size == 1){
                arr[indices.get(0)] = 0;
            }else{
                long nextSum = indices.stream().mapToLong(i -> i).sum();
                long prevSum = 0;
                for(int i = 0; i < size; i++){
                    int index = indices.get(i);
                    long tmp = nextSum - ((long) (size - i) * index);
                    tmp += Math.abs(prevSum - (long)i * index);
                    arr[index] = tmp;
                    nextSum -= index;
                    prevSum += index;
                }
            }
        }
        return arr;
    }
}
class Solution {
    public int maxScore(int[] nums) {
        Integer[] arr =  Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        int n = arr.length;
        int ans = 0;
        long p = 0;
        for(int i = 0; i < n; i++){
            p += (long)arr[i];
            if(p > 0){
                ans += 1;
            }else{
                p = 0;
            }
        }
        return ans;
    }
}
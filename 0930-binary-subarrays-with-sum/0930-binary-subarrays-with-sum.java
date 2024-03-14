class Solution {
    public int numSubarraysWithSum(int[] arr, int s) {
        return atMostSum(arr, s) - atMostSum(arr, s - 1);
    }
    
    public int atMostSum(int[] arr, int sum){
        int res = 0;
        int start = 0;
        if(sum < 0 ) return 0;
        for(int end = 0; end < arr.length; end++){
            sum -= arr[end];
            while(sum < 0){
                sum += arr[start];
                start++;
            }
            res += end - start + 1;
        }
        return res;
    }
}
class Solution {
    public int numSubarraysWithSum(int[] arr, int s) {
        int n = arr.length;
        int[] count = new int[n + 1];
        int res = 0;
        
        count[0] = 1;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum >= s){
                res += count[sum - s];
            }
            count[sum]++; 
        }
        return res;
    }
    
    public int numSubarraysWithSum1(int[] arr, int s) {
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
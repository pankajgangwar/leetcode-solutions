class Solution {
    public int maxChunksToSorted1(int[] arr) {
        int n = arr.length;
        
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];
        
        maxOfLeft[0] = arr[0];
        for(int i = 1; i < n; i++){
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
        }
        
        minOfRight[n-1] = arr[n-1];
        for(int i = n - 2; i >= 0; i--){
            minOfRight[i] = Math.min(minOfRight[i+1], arr[i]);
        }
        
        int res = 1;
        for(int i = 0; i < n - 1; i++){
            if(maxOfLeft[i] <= minOfRight[i+1]) res++;
        }
        return res;
    }
    
    public int maxChunksToSorted(int[] arr){
        if(arr == null || arr.length == 0) return 0;
        int res = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if(max == i) res++;
        }
        return res;
    }
}
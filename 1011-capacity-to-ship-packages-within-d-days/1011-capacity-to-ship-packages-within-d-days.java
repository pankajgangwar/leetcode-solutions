class Solution {
    public int shipWithinDays(int[] weights, int D) {
        IntStream stream = Arrays.stream(weights);
        int totalSum = stream.sum();
        int low = Arrays.stream(weights).min().getAsInt();
        int high = totalSum;
        int res = high;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canShip(weights, mid, D)) {
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }
    
    public boolean canShip(int[] arr, int cap, int d){
        for(int i = 0, sum = 0; i < arr.length; i++){
            if(d <= 0) return false;
            if(sum + arr[i] <= cap){
                sum += arr[i];
            }else if(arr[i] <= cap){
                d -= 1;
                sum = arr[i];
            }else{
                return false;
            }
        }
        return d > 0;
    }
}
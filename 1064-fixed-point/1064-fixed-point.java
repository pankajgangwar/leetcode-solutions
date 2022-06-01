class Solution {
    public int fixedPoint(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int res = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] < mid){
                low = mid+1;
            }else if(arr[mid] == mid){
                res = mid;
                high = mid-1;
            }else{
                high = mid-1;
            }
        }
        return res != -1 ? res : -1;
    }
}
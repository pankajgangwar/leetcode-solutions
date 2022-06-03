/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    public int findInMountainArray(int target, MountainArray A) {
        int low = 0;
        int n = A.length();
        int peak = peakIndexInMountainArray(A);
        int high = peak;
        while (low <= high){
            int mid = ( low + high )/ 2;
            int m = A.get(mid);
            if(m == target){
                return mid;
            }else if(m > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        low = peak;
        high = n - 1;
        while (low <= high){
            int mid = ( low + high )/ 2;
            int m = A.get(mid);
            if(m == target){
                return mid;
            }else if(m > target){
                low = mid + 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public int peakIndexInMountainArray(MountainArray A) {
        int l = 0, r = A.length() - 1, mid = 0;
        while(l < r) {
            mid = ( l + r )/ 2;
            int m = A.get(mid);
            if(m < A.get(mid + 1)) {
                l = mid;
            }else if(A.get(mid - 1) > m){
                r = mid;
            }else {
                return mid;
            }
        }
        return 0;
    }
}

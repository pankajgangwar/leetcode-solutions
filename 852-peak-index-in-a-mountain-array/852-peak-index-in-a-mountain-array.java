class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length - 1, mid = 0;
		
		while(l < r) {
			mid = ( l + r )/ 2;
			if(A[mid] < A[mid + 1]) {
				l = mid;
			}else if(A[mid - 1] > A[mid]){
				r = mid;
			}else {
				return mid;
			}
		}
		return 0;
    }
}
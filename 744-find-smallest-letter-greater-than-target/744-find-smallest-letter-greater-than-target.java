class Solution {
    public char nextGreatestLetter(char[] a, char t) {
        int n = a.length;
        int low = 0, high = a.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(a[mid] <= t){
                low = mid + 1;
            }else if(a[mid] > t){
                high = mid - 1;
            }
        }
        return a[low % n];
    }
}
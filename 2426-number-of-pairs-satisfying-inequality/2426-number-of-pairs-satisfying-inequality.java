class Solution {
     public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int[] arr = new int[nums1.length];
        
        int n = arr.length;
        for(int i = 0; i < nums1.length; i++){
            arr[i] = nums1[i] - nums2[i];
        }
        mergesort(arr, 0, n - 1, diff);
        return ans;
    }

    public void mergesort(int[] arr, int l, int r, int diff){
        if(l < r){
            int mid = l + (r - l)/2;
            mergesort(arr, l, mid, diff);
            mergesort(arr, mid + 1, r, diff);
            merge(arr, l, mid, r, diff);
        }
    }

    long ans = 0;
    private void merge(int[] arr, int l, int mid, int r, int diff) {
        int i = l, j = mid + 1;
        while (i <= mid && j <= r){
            if(arr[i] <= arr[j] + diff){
                ans += (r - j + 1);
                i++;
            }else{
                j++;
            }
        }
        Arrays.sort(arr, l, r + 1);
    }
}
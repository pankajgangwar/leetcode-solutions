class Solution {
    public int findKthLargest(int[] nums, int k) {
        //return quickSelectRec(nums, nums.length - k, 0, nums.length -1);
        return quickSelect(nums, k);
        //return usingMaxHeap(nums, k);
    }
    
    public int usingMaxHeap(int[] nums, int k){
        PriorityQueue<Integer> maxHeap 
            = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : nums) {
	        maxHeap.add(ele);
	    }
         while(k > 1) {
	        maxHeap.poll();
	        k--;
	     }
	     return maxHeap.peek();
    }
    
    public int quickSelect(int[] a, int k){
        int low = 0;
        int high = a.length - 1;

        k = a.length - k;

        while(low < high) {
            int pivot = hoarePartition(a, low, high);
            if(pivot < k){
                low = pivot + 1;
            }else if(pivot > k){
                high = pivot - 1;
            }else{
                break;
            }
        }

        return a[k];
    }
    
    public int quickSelectRec(int[] a, int k, int low, int high){
        if(low < high){
            int pivot = hoarePartition(a, low, high);
            if(pivot < k){
                low = pivot + 1;
            }else if (pivot > k){
                high = pivot - 1;
            }else{
                return a[k];
            }

            quickSelectRec(a, k, low, pivot - 1);
            quickSelectRec(a, k, pivot + 1, high);
        }

        return a[k];
    }

    public int hoarePartition(int[] a, int low, int high){
        int pivot = a[low];
        int i = low;
        int j = high + 1;

        while(true){
            while(i < high && a[++i] < pivot);
            while(j > low && pivot < a[--j]);
            if(i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }
    
    public void swap(int[] a,int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
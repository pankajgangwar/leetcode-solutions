class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            int p = hoaresPartition(arr, low, high);
            quickSort(arr, low, p - 1 );
            quickSort(arr, p + 1, high);
        }
    }
    
    public int lomutoPartition(int[] arr, int low, int high ){
        int pivot = arr[high];
        int i = low;
        for (int j = low; j <= high; j++) {
            if(arr[j] < pivot){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    public int hoaresPartition(int[] a, int low, int high){
        int pivot = a[low];
        int i = low;
        int j = high + 1;
        while(true){
            do {
                i++;
            }while (i < high && a[i] < pivot);

            do {
                j--;
            }while (j > low && pivot < a[j]);

            /*while(i < high && a[++i] < pivot);
            while(j > low && pivot < a[--j]);*/
            if(i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }

    public void swap(int[] a , int i, int j ){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
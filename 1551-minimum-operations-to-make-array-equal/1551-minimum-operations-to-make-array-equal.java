class Solution {
    public int minOperations(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (2 * i) + 1;
        }
        //System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        int res = 0;
        int i = 0, j = n -1;
        while (i < j){
            int tar = (arr[i] + arr[j]) / 2;
            int diff = tar - arr[i];
            res += diff;
            arr[i] += diff;
            arr[j] -= diff;
            i++;
            j--;
        }
        return res;
    }
}
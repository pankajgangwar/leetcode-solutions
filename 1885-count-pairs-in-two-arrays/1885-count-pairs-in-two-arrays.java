class Solution {
    public long countPairs(int[] n1, int[] n2) {
        int n = n1.length;
        int[]arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n1[i]  - n2[i];
        }
        Arrays.sort(arr);
        long count = 0;
        for (int i = 0, j = n - 1; i < n; i++) {
            while (j > i && arr[i] + arr[j] > 0){
                j--;
            }
            if(j >= i){
                count += (n - j - 1);
            }else{
                count += (n - i - 1);
            }
        }
        return count;
    }
}
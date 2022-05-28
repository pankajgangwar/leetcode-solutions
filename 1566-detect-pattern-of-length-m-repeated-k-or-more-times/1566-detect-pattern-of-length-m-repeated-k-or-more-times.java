class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        for (int i = 0; i + m * k - 1 < n ; i++) {
            boolean found = true;
            for (int j = 0; j < m * (k - 1); j++) {
                if(arr[i + j] != arr[ i + (j + m)]){
                    found = false;
                    break;
                }
            }
            if(found) return true;
        }
        return false; 
    }
}
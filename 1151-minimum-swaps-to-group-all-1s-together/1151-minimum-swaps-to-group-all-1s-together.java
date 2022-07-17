class Solution {
    public int minSwaps(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) count++;
        }
        int zeroInWindow = 0;
        for (int i = 0; i < count; i++) {
            if(arr[i] == 0) zeroInWindow++;
        }
        int res = zeroInWindow;
        int start = 0;
        for (int i = count; i < arr.length ; i++) {
            if(arr[i] == 0) zeroInWindow++;
            if(arr[start++] == 0) zeroInWindow--;
            res = Math.min(res, zeroInWindow);
        }
        return res;
    }
}
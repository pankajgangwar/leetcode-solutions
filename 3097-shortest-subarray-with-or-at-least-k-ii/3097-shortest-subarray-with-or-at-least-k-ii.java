class Solution {
    public int minimumSubarrayLength(int[] arr, int k){
        int n = arr.length;
        int[] bitCount = new int[32];

        int orVal = 0;
        int ans = Integer.MAX_VALUE;
        for(int end = 0, start = 0; end < n; end++) {
            orVal |= arr[end];
            performOrOperation(bitCount, (long)arr[end]);
            if(orVal < k)continue;
            for (; start <= end && orVal >= k; start++){
                orVal = nullifyOrOperation(orVal, bitCount, (long)arr[start]);
                ans = Math.min(ans, end - start + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int nullifyOrOperation(int orVal, int[] bitCount, long n) {
        for (int i = 0; i < 32; i++) {
            //bitCount[i] -= (n & (1 << i));
            if((n & (1 << i)) > 0){
                bitCount[i] -= 1;
            }
            if(bitCount[i] == 0) orVal = orVal & (~(1<<i));
        }
        return orVal;
    }

    private void performOrOperation(int[] bitCount, long n) {
        for (int i = 0; i < 32; i++) {
            //bitCount[i] += n & (1 << i) ;
            if((n & (1 << i)) > 0){
                bitCount[i] += 1;
            }
        }
    }
}
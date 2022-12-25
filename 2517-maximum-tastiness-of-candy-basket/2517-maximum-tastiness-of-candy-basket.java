class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int low = 0, high = (int)1e9;
        while (low < high){
            int mid = low + (high - low) / 2;
            if(check(mid, price, k)) low = mid + 1;
            else high = mid;
        }
        return low - 1;
    }

    private boolean check(int mid, int[] price, int k) {
        int last = price[0], i = 1, count = 1;
        while (i < price.length && count < k){
            if(price[i] - last >= mid){
                last = price[i];
                count++;
            }
            i += 1;
        }
        return count == k;
    }
}
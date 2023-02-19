class Solution {
    public int minOperations(int n) {
        int pow = (int)(Math.log(n) / Math.log(2));
        if((1 << pow) == n) return 1;
        int diff1 = minOperations(n - (1 << pow));
        int diff2 = minOperations((1 << (pow + 1)) - n);
        return 1 + Math.min(diff1, diff2);
    }
}
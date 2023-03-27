class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int [] arr = new int[numOnes + numZeros + numNegOnes];
        for (int i = 0; i < numOnes; i++) {
            arr[i] = 1;
        }
        for(int i = numOnes; i < numOnes + numZeros; i++){
            arr[i] = 0;
        }
        for (int i = numOnes + numZeros; i < arr.length ; i++) {
            arr[i] = -1;
        }
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < Math.min(n, k); i++) {
            sum += arr[i];
        }
        return sum;
    }
}
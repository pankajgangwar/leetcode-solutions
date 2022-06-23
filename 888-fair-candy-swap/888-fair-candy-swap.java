class Solution {
    public int[] fairCandySwap(int[] a, int[] b) {
        int aSum = Arrays.stream(a).sum();
        int bSum = Arrays.stream(b).sum();
        int diff = (aSum - bSum) / 2;
        Arrays.sort(a);
        for (int num : b) {
            int A = num + diff;
            int B = Arrays.binarySearch(a, A);
            if(B >= 0){
                return new int[]{A, num};
            }
        }
        return new int[]{};
    }
    

}
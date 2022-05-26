class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        int[] arr = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
        HashSet<Integer> set = new HashSet<>();
        for(int a : arr) set.add(a);
        
        for(int i = left; i <= right; i++){
            int bits = Integer.bitCount(i);
            if(set.contains(bits)){
                count += 1;
            }
        }
        return count;
    }
    
    public boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;
  
        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
  
        return true;
    }
}
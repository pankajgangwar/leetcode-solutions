class Solution {
    public boolean primeSubOperation(int[] nums) {
        TreeSet<Integer> primes = sieveOfEratosthenes(1001);
        int last = 0;
        for (int a : nums) { // last 0, 3, 8
            a = a - last; // 6 - 8 = -2
            int mn = a; // 6
            if(mn <= 0) return false;
            Integer p = primes.lower(a); // 5
            if(p == null) last = last + mn;
            else last = last + (a - p); // 8
        }
        return true;
    }
    public TreeSet<Integer> sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i <= n; i++){
            prime[i] = true;
        }
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i]){
                set.add(i);
            }
        }
        return set;
    }
}
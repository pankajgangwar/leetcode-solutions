class Solution {
    
    public int minOperations(int n) {
        return f(n);
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    public int f(int n) {
        if(map.containsKey(n)) return map.get(n);
        if(n == 0) return 0;
        if((n & (n - 1)) == 0) return 1;
        int x = n & -n;
        int res = 1 + Math.min(f(n - x), f(n + x));
        map.put(n, res);
        return res;
    }
    
    public int minOperations1(int n) {
        int pow = (int)(Math.log(n) / Math.log(2));
        if((1 << pow) == n) return 1;
        int diff1 = minOperations(n - (1 << pow));
        int diff2 = minOperations((1 << (pow + 1)) - n);
        return 1 + Math.min(diff1, diff2);
    }
    
}
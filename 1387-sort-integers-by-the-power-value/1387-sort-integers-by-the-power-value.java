class Solution {
    public int getKth(int lo, int hi, int k) {
        List<int[]> list = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            list.add(new int[]{getPower(i), i});
        }
        list.sort(Comparator.comparingInt(a -> a[0]));
        return list.get(k-1)[1];
    }

     HashMap<Integer, Integer> memo = new HashMap<>();
    public int getPower(int n){
        if(n == 1 ) return n;
        if(memo.containsKey(n)) return memo.get(n);
        int res = 0;
        if(n % 2 == 0){
             res = 1 + getPower(n / 2);
        }else{
            res = 1 + getPower(3 * n + 1);
        }
        memo.put(n, res);
        return memo.get(n);
    }
}
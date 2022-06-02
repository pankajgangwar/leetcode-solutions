class Solution {
    public int confusingNumberII(int N) {
        map.put(8, 8);
        map.put(9, 6);
        map.put(6, 9);
        map.put(1, 1);
        map.put(0, 0);

        helper(N, 0);
        return res;
    }

    int res = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public void helper(int n, long curr){
        if(confusingNumber(curr)){
            res++;
        }
        for(Integer i : map.keySet()){
            if(curr * 10 + i <= n && curr * 10 + i != 0){
                helper(n, curr * 10 + i);
            }
        }
    }

    public boolean confusingNumber(long N) {
        long src = N;
        long res = 0;
        while (N > 0){
            res = res * 10 + map.get((int)N % 10);
            N /= 10;
        }
        return src != res;
    }
    
}
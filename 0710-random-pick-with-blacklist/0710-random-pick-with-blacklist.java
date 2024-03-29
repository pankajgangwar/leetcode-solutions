class Solution {

    int n, m;
    HashMap<Integer, Integer> map = new HashMap<>();
    Random r = new Random();
    public Solution(int n, int[] blacklist) {
        this.n = n;
        for(int a : blacklist){
            map.put(a, -1);
        }
        this.m = n - blacklist.length;
        for(int a : blacklist){
            if(a >= m) continue;
            while (map.containsKey(n - 1)) {
                n -= 1;
            }
            map.put(a, n - 1);
            n -= 1;
        }
    }

    public int pick() {
        int number = r.nextInt(m);
        if(map.containsKey(number)){
            return map.get(number);
        }
        return number;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
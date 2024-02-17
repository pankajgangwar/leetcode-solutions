class Solution {
    int mod = 1000000007;
    int prod = 1;
    public int waysToBuildRooms(int[] prevRoom) {
        HashMap<Integer, List<Integer>> al = new HashMap<>();
        int n = prevRoom.length;
        long fact = 1;
        for (int i = 0; i < n; i++) {
              //al.putIfAbsent(i, new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            al.putIfAbsent(prevRoom[i], new ArrayList<>());
            al.get(prevRoom[i]).add(i);
            fact = fact * (i + 1) % mod;
        }
        int[] size = new int[n];
        int ans = dfs(0, size, al);
        long d = 1L;
        for(int i = 0; i < n; i++){
            d = (d * size[i]) % mod;
        }
        int inverse = (int) (binpow((int)d, mod - 2) % mod);
        return (int)((fact * inverse) % mod);
    }

    
    public int dfs(int src, int[] size,
                   HashMap<Integer, List<Integer>> al){
        int total = 1;
        for(int adj : al.getOrDefault(src, new ArrayList<>())){
            total += dfs(adj, size, al);
        }
        size[src] = total;
        return total;
    }
    
    long binpow(int a, int b) {
        if (b == 0) return 1L;
        long res = binpow(a, b / 2) % mod;
        res = (res * res) % mod;
        return (b % 2 == 1) ? ((res * a) % mod) : res;
    }
}
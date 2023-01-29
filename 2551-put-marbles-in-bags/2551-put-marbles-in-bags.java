class Solution {
    public long putMarbles(int[] weights, int k) {
        if(k == 1 || k == weights.length) return 0;
        long ans = 0;
        long res = 0;
        k -= 1;
        List<Long> ss = new ArrayList<>();
        for(int i = 0; i < weights.length - 1; i++ ){
            ss.add((long) (weights[i]+weights[i+1]));
        }
        List<Long> rr = new ArrayList<>(ss);
        Collections.sort(ss, Collections.reverseOrder());
        Collections.sort(rr);
        for(int i = 0; i < k; i++){
            ans += ss.get(i);
        }
        for(int i = 0; i < k; i++){
            res += rr.get(i);
        }
        return (ans - res);
    }
}
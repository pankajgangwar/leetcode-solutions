class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if(k == 1 || k == n) return 0;
        k -= 1;
        List<Long> sum = new ArrayList<>();
        for(int i = 0; i < n - 1; i++ ){
            sum.add((long) (weights[i]+weights[i+1]));
        }
        long max = 0;
        long min = 0;
        Collections.sort(sum);
        for(int i = 0; i < k; i++){
            min += sum.get(i);
            max += sum.get(n - i - 1 - 1);
        }
        return (max - min);
    }
}
class Solution {
    public long appealSum(String s) {
        int n = s.length();
        int[] u = new int[26];
        Arrays.fill(u, -1);
        long res = 0;
        for (int i = 0; i < n; i++) {
            u[s.charAt(i) - 'a'] = i;
            int[] v = Arrays.copyOf(u, 26);
            //Arrays.sort(v);
            for (int j = 0; j < 26 ; j++) {
                if(v[j] >= 0){
                    res += v[j] + 1;
                }
            }
        }
        return res;
    }
}
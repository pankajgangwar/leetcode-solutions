class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        int[][] res = new int[queries.length][2];
        int n = s.length();
        HashMap<Long, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '0') {
                if(!map.containsKey(0L)){
                    map.put(0L, new int[]{i,i});
                }
                continue;
            }
            long num = 0;
            for(int j = i; j <= Math.min(i + 32, n-1); j++){
                num = (num << 1) + (s.charAt(j) - '0');
                if(!map.containsKey(num)){
                    map.put(num, new int[]{i,j});
                }
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            long val = q[0]^q[1];
            if(map.containsKey(val)){
                res[i] = new int[]{map.get(val)[0], map.get(val)[1]};
            }else{
                res[i] = new int[]{-1,-1};
            }
        }
        return res;
    }
}
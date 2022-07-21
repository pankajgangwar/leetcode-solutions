class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '|'){
                list.add(i);
            }
        }
        int q = queries.length;
        int[] res = new int[q];
        int[] prefixSum = new int[list.size()];
        if(list.isEmpty()) return res;

        for (int i = 1; i < list.size() ; i++) {
            prefixSum[i] = prefixSum[i - 1] + list.get(i) - list.get(i - 1) -1;
        }

        for (int i = 0; i < q; i++) {
            int[] qq = queries[i];
            int left = Collections.binarySearch(list, qq[0]);
            if(left < 0) {
                left = ~left;
            }
            int right = Collections.binarySearch(list, qq[1]);
            if(right < 0) {
                right = ~right;
                right -= 1;
            }
            int plates = 0;
            if(left <= right){
                plates += prefixSum[right] - prefixSum[left];
            }
            res[i] = plates;
        }
        return res;
    }
}
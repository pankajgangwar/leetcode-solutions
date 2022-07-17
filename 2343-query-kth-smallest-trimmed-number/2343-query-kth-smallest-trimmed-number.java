class Solution {
    class Pair {
        String val;
        int index;
        public Pair(String val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int k = nums[0].length();
        int len = nums.length;
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        HashSet<Integer> trims = new HashSet<>();
        for(int[] q : queries){
            trims.add(q[1]);
        }
        for (int i : trims) {
            map.putIfAbsent(i, new ArrayList<>());
            for (int j = 0; j < len; j++) {
                String trim = nums[j].substring(k-i);
                int l = 0;
                while (l < trim.length() && trim.charAt(l) == '0'){
                    l++;
                }
                trim = trim.substring(l);
                List<Pair> list = map.get(i);
                list.add(new Pair(trim, j));
                map.put(i, list);
            }
            List<Pair> arr = map.get(i);
            Collections.sort(arr, (a, b) -> {
                if(a.val.length() == b.val.length()){
                    int cmp = a.val.compareTo(b.val);
                    if(cmp == 0){
                        return a.index - b.index;
                    }
                    return cmp;
                }else{
                    return a.val.length() - b.val.length();
                }
            });
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int kthSmallest = queries[i][0] - 1;
            int trimDigit = queries[i][1];
            List<Pair> r = map.get(trimDigit);
            res[i] = r.get(kthSmallest).index;
        }
        return res;
    }
}
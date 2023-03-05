class Solution {
    public int findValidSplit(int[] nums) {
        HashMap<Integer, Integer> pos = new HashMap<>();
        HashMap<Integer, List<Integer>> primeFac = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            primeFac.putIfAbsent(i, new ArrayList<>());
            for (int j = 2; j*j <= a; j++){
                if(a % j == 0){
                    primeFac.get(i).add(j);
                    pos.put(j, i);
                    while(a % j == 0){
                        a /= j;
                    }
                }
            }
            if(a > 1){
                primeFac.get(i).add(a);
                pos.put(a, i);
            }
        }
        int max = -1;
        for (int i = 0; i < n - 1; i++) {
            for(int j : primeFac.get(i)){
                max = Math.max(max, pos.get(j));
            }
            if(max == i) return i;
        }
        return -1;
    }
}
class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        int n = changed.length;
        int[] empty = new int[]{};
        if(n % 2 != 0) return empty;
        int[] res = new int[n / 2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : changed){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int resIdx = 0;
        for (int i = 0; i < n; i++) {
            int d = changed[i] * 2;
            if(resIdx == n / 2) break;
            if(map.get(changed[i]) <= 0) continue;
            if(map.containsKey(d) && map.get(d) > 0){
                if(d == 0){
                    int freq = map.get(0);
                    if(freq % 2 != 0) return empty;
                    while (freq >= 2){
                        res[resIdx++] = 0;
                        freq -= 2;
                    }
                    map.put(0, 0);
                    continue;
                }
                map.put(d, map.get(d) - 1);
                map.put(changed[i], map.getOrDefault(changed[i], 1) - 1);
                res[resIdx++] = changed[i];
            }
        }
        if(resIdx != n / 2) return empty;
        return res;
    }
}
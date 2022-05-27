class Solution {
    public int[] amountPainted(int[][] paint) {
        
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int n = paint.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int[] p = paint[i];
            int left = p[0], right = p[1];
            int toPaint = right - left;
            if(map.floorKey(left) != null
                    && map.get(map.floorKey(left)) > left){
                int l = map.floorKey(left);
                int r = map.get(l);
                if(r >= right) continue;
                toPaint -= (r - left);
                map.remove(l);
                left = l;
            }
            Integer start = p[0];
            while(start != null && map.ceilingKey(start) != null
                    && map.ceilingKey(start) <= right){
                int l = map.ceilingKey(start);
                int r = map.get(l);
                toPaint -= Math.min(r, right) - l;
                map.remove(l);
                right = Math.max(right, r);
                start = map.ceilingKey(p[0]);
            }
            map.put(left, right);
            res[i] = toPaint;
        }
        return res;
        
    }
}
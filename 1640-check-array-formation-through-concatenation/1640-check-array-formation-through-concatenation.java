class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for(int[] p : pieces){
            int first = p[0];
            int idx1 = map.getOrDefault(first, -1);
            if(idx1 < 0) return false;
            for (int i = 1; i < p.length; i++) {
                int idx2 = map.getOrDefault(p[i], -1);
                if(idx2 < 0) return false;
                if(idx1 > idx2) return false;
                if(idx1 + i != idx2) return false;
            }
        }
        return true;
    }
}
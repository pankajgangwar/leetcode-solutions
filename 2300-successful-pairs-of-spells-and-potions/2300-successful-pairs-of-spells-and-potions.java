class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            int s = spells[i];
            int low = 0, high = m - 1;
            int pos = -1;
            while (low <= high){
                int mid = low + (high - low) / 2;
                if((long)potions[mid]*s >= success){
                    pos = mid;
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            if(pos != -1){
                res[i] = m - pos;
            }
        }
        return res;
    }
}
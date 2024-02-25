class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[] freq = new int[101];
        for(int a : nums){
            freq[a]++;
        }
        int distinct = 0;
        for (int i = 0; i < freq.length; i++) {
            if(freq[i] == 0) continue;
            if(freq[i] > 2 ) return false;
            if(freq[i] == 1) distinct++;
        }
        return distinct % 2 == 0;
    }
}
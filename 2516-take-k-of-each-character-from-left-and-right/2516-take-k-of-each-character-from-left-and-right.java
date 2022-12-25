class Solution {
    public int takeCharacters(String s, int k) {
        int min = Integer.MAX_VALUE;
        int[]occ = new int[3];
        for(char ch : s.toCharArray()){
            occ[ch - 'a']++;
        }
        if(occ[0] < k || occ[1] < k || occ[2] < k) return -1;
        for (int start = 0, end = 0; end < s.length() ; end++) {
            occ[s.charAt(end) - 'a']--;
            while (start <= end && (occ[0] < k || occ[1] < k || occ[2] < k)){
                occ[s.charAt(start++) - 'a']++;
            }
            min = Math.min(min, s.length() - (end - start + 1));
        }
        return min;
    }
}
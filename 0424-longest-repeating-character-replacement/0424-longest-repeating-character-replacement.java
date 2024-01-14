class Solution {
    public int characterReplacement(String s, int k) {
        int maxCharCount = 0;
        int start = 0;
        int end = 0;
        int[] count = new int[26];
        int n = s.length();
        int result = 0;
        for(end = 0; end < n; end++){
            int endIdx = s.charAt(end) - 'A';
            count[endIdx]++;
            if(maxCharCount < count[endIdx]){
                maxCharCount = count[endIdx];
            }
            while(end - start + 1 - maxCharCount > k){
                count[s.charAt(start) - 'A']--;
                start++;
                for(int i = 0; i < 26; i++){
                    if(maxCharCount < count[i]){
                        maxCharCount = count[i];
                    }
                }
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}
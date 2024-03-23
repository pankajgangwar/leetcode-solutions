class Solution {
    public int minimumDeletions(String word, int k) {
        int n = word.length();
        int[] freq = new int[26];
        int maxx = 0;
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
            maxx = Math.max(maxx, freq[ch - 'a']);
        }
        Arrays.sort(freq);

        int del = Integer.MAX_VALUE;
        for(int i = 1; i <= maxx; i++){
            int count = 0;
            for (int j = 0; j < 26; j++) {
                if(freq[j] > i + k){
                    count += freq[j] - i - k;
                }else if(freq[j] < i){
                    count += freq[j];
                }
            }
            del = Math.min(del, count);
        }
        return del;
    }
}
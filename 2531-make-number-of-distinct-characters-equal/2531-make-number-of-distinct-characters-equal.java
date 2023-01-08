class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] freq1 = new int[26];
        for(char ch : word1.toCharArray()){
            freq1[ch - 'a']++;
        }
        int[] freq2 = new int[26];
        for(char ch : word2.toCharArray()){
            freq2[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(freq1[i] == 0) continue;
            freq1[i]--;
            for (int j = 0; j < 26; j++) {
                if(freq2[j] == 0) continue;
                freq2[j]--;
                
                freq1[j]++;
                freq2[i]++;
                
                if(distinctCharsAreSame(freq1, freq2)) return true;
                freq1[j]--;
                freq2[i]--;
                
                freq2[j]++;
            }
            freq1[i]++;
        }
        return false;
    }

    private boolean distinctCharsAreSame(int[] freq1, int[] freq2) {
        int cnt1 = 0, cnt2 = 0;
        for(int a : freq1) {
            if(a != 0) {
                cnt1++;
            }
        }
        for(int a : freq2) {
            if(a != 0) {
                cnt2++;
            }
        }
        return cnt1 == cnt2;
    }
}
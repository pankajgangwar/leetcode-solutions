class Solution {
    public int minimumKeypresses(String s) {
        Integer[] freq = new Integer[26];
        Arrays.fill(freq, 0);
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        Arrays.sort(freq, (a,b) -> b - a);
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += freq[i] * ((i + 9)/9);
        }
        return count;
    }
}
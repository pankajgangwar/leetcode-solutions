class Solution {
    public int maxRepeating(String seq, String word) {
        int k = 1;
        while(seq.contains(word.repeat(k))) {
            k += 1;
        }
        return k - 1;
    }
}
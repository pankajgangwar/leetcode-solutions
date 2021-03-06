class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            String w = words[i];
            for (int j = 0; j < w.length(); j++) {
                mask[i] |= 1 << w.charAt(j) - 'a';
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i ; j++) {
                String w1 = words[i];
                String w2 = words[j];
                if((mask[i] & mask[j]) == 0){
                    maxProduct = Math.max(maxProduct, w1.length() * w2.length());
                }
            }
        }
        return maxProduct;
    }
}
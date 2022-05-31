class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> allComb = new HashSet<>();
        for (int i = 0; i <= s.length() - k ; i++) {
            allComb.add(s.substring(i, i + k));
        }
        return allComb.size() == Math.pow(2, k);
    }

}
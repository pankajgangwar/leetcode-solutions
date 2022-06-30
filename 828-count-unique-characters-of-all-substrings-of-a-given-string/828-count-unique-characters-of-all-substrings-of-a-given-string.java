class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        ArrayList<Integer>[] list = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            list[s.charAt(i) - 'A'].add(i);
        }
        long result = 0, mod = (int)1e9+7;;
        for (int i = 0; i < 26; i++) {
            int size = list[i].size();
            for (int j = 0; j < size; j++) {
                int currIndex = list[i].get(j);
                int left = j == 0 ? -1 : list[i].get(j - 1);
                int right = (j == size - 1) ? n : list[i].get(j + 1);
                result += (long) (currIndex - left) * (right - currIndex);
                result %= mod;
            }
        }
        return (int)result;
    }
    
    public int uniqueLetterStringSol(String s) {
        int n = s.length();
        int[][] index = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(index[i], -1);
        }
        int res = 0, mod = (int)1e9+7;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            res = (res + (i - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
            index[c][0] = index[c][1];
            index[c][1] = i;
        }
        for (int i = 0; i < 26; i++) {
            res = (res + (n - index[i][1]) * (index[i][1] - index[i][0]) % mod ) % mod;
        }
        return res;
    }
    
}
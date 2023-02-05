class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] ans = new int[n];
        for (int i = 0; i < words.length; i++) {
            if(isVowel(words[i].charAt(0))
                    && isVowel(words[i].charAt(words[i].length() - 1))){
                ans[i] = 1;
            }
        }
        int[] prefSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefSum[i] = prefSum[i - 1] + ans[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length ; i++) {
            int[] q = queries[i];
            int sum = prefSum[q[1] + 1] - prefSum[q[0]];
            res[i] = sum;
        }
        return res;
    }
    
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}
class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder res = new StringBuilder(), stack = new StringBuilder();
        for (int i = 0, j = 0; i <= n; i++) {
            stack.append((i+1));
            if(i == n || pattern.charAt(i) == 'I'){
                res.append(stack.reverse());
                stack = new StringBuilder();
            }
        }
        return res.toString();
    }
}
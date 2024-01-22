class Solution {
    public List<String> generateParenthesis(int n) {
        helper(n, 0, 0, "");
        return res;
    }
    List<String> res = new ArrayList<>();
    public void helper(int n, int open, int close, String out){
        if(out.length() == n * 2){
            res.add(out.toString());
            return;
        }
        if(open < n){
            helper(n, open + 1, close, out + "(");
        }
        if(open > close){
            helper(n, open, close + 1, out + ")");
        }
    }
}
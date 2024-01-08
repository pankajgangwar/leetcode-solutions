class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k, n, 1, new ArrayList<>());
        return res;
    }
    
    List<List<Integer>> res = new ArrayList<>();
    HashSet<String> sets = new HashSet<>();
    public void helper(int k, int n, int start, List<Integer> curr){
        if(n < 0) return;
        if(n == 0 && curr.size() == k) {
            List<Integer> ans = new ArrayList<>(curr);
            if(sets.contains(ans.toString())){
                return;
            }
            sets.add(ans.toString());
            res.add(ans);
            return;
        }
        
        for(int i = start; i <= 9; i++){
            if(i > n) continue;
            curr.add(i);
            helper(k, n - i, i + 1, curr);
            curr.remove(curr.size()-1);
        }
    }
}
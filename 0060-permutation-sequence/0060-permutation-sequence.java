class Solution {
    
    public String getPermutation(int n, int k) {
        LinkedList<Integer> nums = new LinkedList<>();

        int[] fact = new int[n];

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        
        for (int i = 1; i < n; i++) {
            fact[i] = i * fact[i-1];
        }
        
        k = k -1;

        StringBuilder builder = new StringBuilder();
        for (int i = n; i > 0; --i) {
            int idx = k / fact[i -1];
            k = k % fact[i-1];
            builder.append(nums.remove(idx));
        }
        return builder.toString();
    }
    
    public String getPermutationIterative(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<Integer>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        for (int i = 0, l = k - 1; i < n; i++) {
            fact /= (n - i);
            int index = (l / fact);
            sb.append(num.remove(index));
            l -= index * fact;
        }
        return sb.toString();
    }
    
    public String getPermutationTLE(int n, int k) {
        HashSet<Integer> sets = new HashSet<>();
        
        List<List<Integer>> res = new ArrayList<>();
            
        helper(n, k, sets, new ArrayList<Integer>(), res);
        
        return ans;
    }
    
    String ans = "";
    
    public void helper(int n, int k, HashSet<Integer> sets, ArrayList<Integer> res, List<List<Integer>> allPerm) {

        if(allPerm.size() > k){
            return;
        }
        
        if (res.size() == n) {
            allPerm.add(new ArrayList<>(res));
            if (k == allPerm.size() && ans.length() == 0) {
                List<Integer> finalans = allPerm.get(allPerm.size() - 1);
                for (int ele : finalans) ans += ele;
            }
            return;  
        }
         
        for(int i = 1; i <= n; i++){
            if(allPerm.size() > k) break;
            
            if(sets.contains(i)) continue;

                sets.add(i);
                res.add(i);
                helper(n, k, sets, res, allPerm);
                res.remove(res.size()-1);
                sets.remove(i);
        }
    }
}
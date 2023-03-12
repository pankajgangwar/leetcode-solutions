class Solution {
    class Trie {
        HashMap<Integer, Trie> map = new HashMap<>();
        int cnt = 0;
        public int insert(int[] nums, int i, int k, int p){
            if(i == nums.length || k - ((nums[i] % p == 0) ? 1 : 0) < 0){
                return 0;
            }
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new Trie());
            }
            int kk = nums[i] %  p == 0 ? 1 : 0;
            int a = ++map.get(nums[i]).cnt == 1 ? 1 : 0;
            return a + map.get(nums[i]).insert(nums, i + 1, k - kk, p);
        }
    }
    
    public int countDistinct1(int[] nums, int k, int p) {
        int res = 0;
        Trie t = new Trie();
        for (int i = 0; i < nums.length; i++) {
            res += t.insert(nums, i, k, p);
        }
        return res;
    }
    
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        HashSet<Long> sets = new HashSet<>();
        int max = Arrays.stream(nums).max().getAsInt();
        long mod = (long)1e10+7;
        for (int i = 0; i < n; i++) {
            int count = 0;
            long hash = 0;
            for (int j = i; j < n; j++) {
                hash = (hash * (max + 1) + nums[j]) % mod;
                if(nums[j] % p == 0) count++;
                if(count > k) break;
                sets.add(hash);
            }
        }
        return sets.size();
    }
    
}
class Solution {
    
    public int[] smallestSufficientTeam(String[] req_skills, 
                                        List<List<String>> people) {
        int n = req_skills.length;
        int m = people.size();
        List<Integer>[] dp = new List[1 << n];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(req_skills[i], i);
        }
        dp[0] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int curr_skill = 0;
            for(String skill : people.get(i)){
                int idx = map.get(skill);
                curr_skill = curr_skill | (1 << idx);
            }
            for(int prev = 0; prev < dp.length; prev++){
                if(dp[prev] == null) continue;
                int comb = prev | curr_skill;
                if(dp[comb] == null || dp[comb].size() > dp[prev].size() + 1 ){
                    dp[comb] = new ArrayList<>(dp[prev]);
                    dp[comb].add(i);
                }
            }
        }
        return dp[(1 << n) - 1].stream().mapToInt(i -> i).toArray();
    }

}
import java.util.SortedMap;

class Solution {
    public long maximumTotalDamage(int[] power) {
        HashMap<Integer, Integer> damageFreq = new HashMap<>();
        for(int damage : power){
            damageFreq.put(damage, damageFreq.getOrDefault(damage, 0) + 1);
        }
        List<Integer> uniqueDamages = new ArrayList<>(damageFreq.keySet());
        Collections.sort(uniqueDamages);
        int m = uniqueDamages.size();
        long[] dp = new long[m];
        dp[0] = (long) uniqueDamages.get(0) * damageFreq.get(uniqueDamages.get(0));

        for(int i = 1; i < m; i++){
            int damage = uniqueDamages.get(i);
            int total = damage * damageFreq.get(damage);
            dp[i] = dp[i-1];
            int prevIdx = i - 1;
            while (prevIdx >= 0 && (uniqueDamages.get(prevIdx) == damage - 1 ||
                    uniqueDamages.get(prevIdx) == damage - 2 ||
                    uniqueDamages.get(prevIdx) == damage + 1 ||
                    uniqueDamages.get(prevIdx) == damage + 2)) {
                prevIdx--;
            }
            if(prevIdx >= 0){
                dp[i] = Math.max(dp[i], dp[prevIdx] + total);
            }else{
                dp[i] = Math.max(dp[i], total);
            }
        }
        return dp[m - 1];
    }
}
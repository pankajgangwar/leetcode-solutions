class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if(dfs(String.valueOf(square), 0, i )){
                sum += (square);
            }
        }
        return sum;
    }

    boolean dfs(String s, int idx, int target){
        if(target == 0 &&  idx == s.length()) return true;
        if(target < 0 && idx == s.length())return false;
        for (int i = idx + 1; i <= s.length() ; i++) {
            String sub = s.substring(idx, i);
            if(sub.isEmpty()) continue;
            int num = Integer.parseInt(sub);
            if(dfs(s, i, target - num)){
                return true;
            }
        }
        return false;
    }
}
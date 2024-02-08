class Solution {
    public int minStickers(String[] stickers, String target) {
        int m = stickers.length;
        int n = target.length();
        int[][] mp = new int[m][26];
        HashMap<String, Integer> dp = new HashMap<>();
        for(int i = 0; i < m; i++){
            for(char ch : stickers[i].toCharArray()) mp[i][ch - 'a']++;
        }
        dp.put("", 0);
        return helper(stickers, mp, dp, target);
    }

    public int helper(String[] stickers, int[][] map, HashMap<String, Integer> dp, String target){
        int ans = Integer.MAX_VALUE;
        if(dp.containsKey(target)) return dp.get(target);
        int[] tar = new int[26];
        //System.out.println(" tar " + target);
        for(char ch : target.toCharArray()){
            tar[ch - 'a']++;
        }
        int m = stickers.length;
        for(int i = 0; i < m; i++){
            if(map[i][target.charAt(0) - 'a'] == 0) continue;
            StringBuilder out = new StringBuilder();
            for(int j = 0; j < 26; j++){
                if(tar[j] > 0){
                    //System.out.println("jth char " + j + " rem " + (tar[j] - map[i][j]));
                    for(int k = 0; k < Math.max(0, tar[j] - map[i][j]); k++){
                        out.append((char)('a' + j));
                    }
                }
            }
            //System.out.println("idx " + i + " builder " + out.toString());
            int res = helper(stickers, map, dp, out.toString());
            if(res != -1) ans = Math.min(ans, res + 1);
        }
        dp.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(target);
    }
}
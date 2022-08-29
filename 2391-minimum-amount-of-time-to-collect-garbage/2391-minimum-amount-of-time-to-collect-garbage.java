class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[] ans = new int[3];
        int n = travel.length;
        int[] pref = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + travel[i - 1];
        }
        int lastM = -1, lastG = -1, lastP = -1;
        for (int i = 0; i < garbage.length; i++) {
            int m = 0, g = 0, p = 0;
            for(char ch : garbage[i].toCharArray()){
                if(ch == 'M'){
                    m += 1;
                }else if(ch == 'G'){
                    g += 1;
                }else{
                    p += 1;
                }
            }
            if(m > 0){
                lastM = i;
                ans[0] += m;
            }
            if(g > 0){
                lastG = i;
                ans[1] += g;
            }
            if(p > 0){
                lastP = i;
                ans[2] += p;
            }
        }
        if(lastM != -1){
            ans[0] += (pref[lastM]);
        }
        if(lastG != -1){
            ans[1] += (pref[lastG]);
        }
        if(lastP != -1){
            ans[2] += (pref[lastP]);
        }
        return ans[0] + ans[1] + ans[2];
    }
}
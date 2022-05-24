class Solution {
    class Rod {
        int blue;
        int green;
        int red;
    }
    public int countPoints(String rings) {
        int n = rings.length();
        Rod[] rods = new Rod[10];
        for (int i = 0; i < n; i+=2) {
            char color = rings.charAt(i);
            int rodIndex = rings.charAt(i + 1) - '0';
            if(rods[rodIndex] == null){
                rods[rodIndex] = new Rod();
            }
            if(color == 'B'){
                rods[rodIndex].blue++;
            }else if(color == 'G'){
                rods[rodIndex].green++;
            }else{
                rods[rodIndex].red++;
            }
        }
        int res = 0;
        for (int i = 0; i < rods.length; i++) {
            if(rods[i] == null)continue;
            if(rods[i].red >= 1 && rods[i].green >= 1 && rods[i].blue >= 1) {
                res += 1;
            }
        }
        return res;
    }
}
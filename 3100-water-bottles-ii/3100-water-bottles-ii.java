class Solution {
    public int maxBottlesDrunk(int n, int ne) {
        int d = n;
        int ex = 0;
        while(n >= ne){
            d += 1;
            n = n - ne + 1;
            ne++;
        }
        return d;
    }
}
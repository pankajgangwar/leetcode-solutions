class Solution {
    public int passThePillow(int n, int time) {
        boolean reversed = false;
        while (time > (n-1)) {
            time -= (n-1);
            reversed = !reversed;
        }
        if(reversed){
            return n - time;
        }else{
            return time + 1;
        }
    }
}
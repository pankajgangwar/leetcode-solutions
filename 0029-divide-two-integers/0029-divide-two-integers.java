class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0){
            sign = -1;
        }
        if(divisor == 0) return 0;
        
        long ans = helper(Math.abs((long)dividend), Math.abs((long)divisor));
        if(ans > Integer.MAX_VALUE) {
            return (int)sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else{
            return (int) (sign == 1 ? ans : -ans);
        }
    }

    public long helper(long div, long divs){
        if(div < divs){
            return 0;
        }
        long sum = divs;
        long mul = 1;
        
        while((sum << 1) <= div){
            sum = sum << 1;
            mul = mul << 1;
        }
        return mul + helper(div - sum, divs);
    }
}
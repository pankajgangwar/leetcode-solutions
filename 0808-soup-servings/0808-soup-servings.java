class Solution {
    double memo[][] = new double[200][200];
    public double soupServings(int n) {
        return n > 4800 ? 1.0 : helper((n + 24)/ 25, (n+24)/  25);
    }

    public double helper(int a, int b){
        if(a <= 0 && b <= 0) return 0.5;
        if(a <= 0) return 1;
        if(b <= 0) return 0;
        if(memo[a][b] > 0) return memo[a][b];
        memo[a][b] = 0.25 * (helper(a - 4, b) + helper(a - 3, b - 1) + helper(a - 2, b - 2) + helper(a - 1, b - 3));
        return memo[a][b];
    }
}
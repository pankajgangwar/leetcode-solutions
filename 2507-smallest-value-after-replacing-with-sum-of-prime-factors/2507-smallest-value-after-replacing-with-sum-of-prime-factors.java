class Solution {
    public int smallestValue(int n) {
        int c = 2;
        int sum = 0;
        int orgN = n;
        while (n > 1) {
            if (n % c == 0) {
                sum += c;
                n /= c;
            } else {
                c++;
            }
        }
        if(orgN == sum) return orgN;
        //System.out.println(n + " " + sum);
        return smallestValue(sum);
    }
}
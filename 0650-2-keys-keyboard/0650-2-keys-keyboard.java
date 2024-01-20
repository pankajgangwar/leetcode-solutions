class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        for (int i = 2; i < n; i++) {
            if(n % i == 0){
               return i + minSteps(n / i);
            }
        }
        return n;
    }
    
    public int minSteps1(int n) {
        if(n == 1) return 0;
        if(n <= 3){
            return n;
        }
        if(n % 2 == 0){
            return 2 + minSteps1(n / 2);
        }else{
            if(n % 3 == 0){
                return 3 + minSteps1(n / 3);
            }else if(n % 5 == 0){
                return 5 + minSteps1(n / 5);
            }else if(isPerfectSq(n)){
                int root = (int)Math.sqrt(n);
                return root + minSteps1(n / root);
            }else{
                int factor = n;
                for (int i = 2; i < n; i++) {
                    if(n % i == 0){
                        factor = i;
                        break;
                    }
                }
                return factor + minSteps1(n / factor);
            }
        }
    }

    
    public boolean isPerfectSq(double n){
        int root = (int)Math.sqrt(n);
        if(root * root == n){
            return true;
        }
        return false;
    }
    
}
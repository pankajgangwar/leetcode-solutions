class Solution {
    public int numberOfSubarrays(int[] a, int k) {
        return atMostKOdd(a, k) - atMostKOdd(a, k -1);
    }

    public int atMostKOdd(int[] a, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0, res = 0;
        int odd = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] % 2 == 1){
                k--;
            }
            while (k < 0){
                if(a[j] % 2 == 1) k++;
                j++;
            }
            res += i - j + 1;
        }
        return res;
    }
}
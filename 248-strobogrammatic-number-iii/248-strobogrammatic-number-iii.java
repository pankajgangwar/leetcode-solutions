import java.math.BigInteger;
class Solution {
    private List<String> helper(int n, int m) {
        if(n == 0) return new ArrayList<>(Arrays.asList(""));
        if(n == 1) return new ArrayList<>(Arrays.asList("0", "1" ,"8"));

        List<String> list = helper(n-2, m);
        List<String> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if(n != m) res.add("0" + s + "0");

            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }

    /* https://leetcode.com/problems/strobogrammatic-number-iii/ */
    public int strobogrammaticInRange(String low, String high) {

        List<String> res = new ArrayList<>();
        for (int i = low.length(); i <= high.length() ; i++) {
            res.addAll(helper(i, i));
        }

        int count = 0;
        for (int i = 0; i < res.size(); i++) {
            String s1 = res.get(i);
            Integer cmp1 = new BigInteger(s1).compareTo(new BigInteger(low));
            Integer cmp2 = new BigInteger(s1).compareTo(new BigInteger(high));
            if(cmp1 >= 0 && cmp2 <= 0){
                count++;
            }
        }
        return count;
    }
}